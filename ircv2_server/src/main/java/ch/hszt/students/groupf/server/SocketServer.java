package ch.hszt.students.groupf.server;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Hashtable;
import java.util.Map;


public class SocketServer {

	private ServerSocket _serverSocket;
	private Map<String, DataOutputStream> _openOutputStreams = new Hashtable<String, DataOutputStream>();
	public SocketServer(int inServerPort){

		listen(inServerPort);
	}


	private void listen(int inServerPort) {

		try {
			_serverSocket = new ServerSocket(inServerPort);
		} catch (IOException e) {
			// TODO Throw Exception, because the ServerSocket could not have been started.
			// User slf4j as Log-Appender for the server-log.
			
			e.printStackTrace();
		}


		while (true) {
//			BufferedReader reader = null;
//			PrintWriter writer = null;

			Socket singleSocket;
			try {
				singleSocket = _serverSocket.accept();
				
//				DataInputStream dInStream = new DataInputStream(_socket.getInputStream());
//				String message = dInStream.readUTF();
//				reader = new BufferedReader(new InputStreamReader(singleSocket.getInputStream()));

//				String socketUserName = reader.readLine();
				String socketUserName = (new DataInputStream(singleSocket.getInputStream())).readUTF();
				DataOutputStream doutStream = new DataOutputStream(singleSocket.getOutputStream());
				
				_openOutputStreams.put(socketUserName, doutStream);
				
				(new ServerThread(this, singleSocket, socketUserName)).start();
				
				
			} catch (IOException e) {
				// TODO Handle IOException
				e.printStackTrace();
			}catch (IllegalArgumentException e) {
				// TODO: Handle IllegalArgumentException (change to IllegalUsernameException)
				e.printStackTrace();
			}

		}
	}
	
	protected void sendJoinedMsg(String inUserName){
		synchronized (_openOutputStreams) {
			for (Map.Entry<String, DataOutputStream> entry : _openOutputStreams.entrySet()){
				if(!entry.getKey().equals(inUserName)){
					try {
						entry.getValue().writeUTF("User " + inUserName + " joined the chatroom");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
			}			
		}
	}

	
	protected void sendToAll(String inMessage, String inSenderUser) {
		synchronized (_openOutputStreams) {
			for (Map.Entry<String, DataOutputStream> entry : _openOutputStreams.entrySet()){
				try {
					entry.getValue().writeUTF(inSenderUser + ": " + inMessage);
//					System.out.println(inSenderUser + " " + inMessage);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			
			
		}
	}
	protected void sendToSpecificUser(String inRecipient, String inMessage){
		synchronized (_openOutputStreams) {

		}
	}
	
	protected void removeConnection(Socket inSocket){
		synchronized (_openOutputStreams) {
			// TODO Appender to logger that a Connection is removed
			_openOutputStreams.remove(inSocket);
			
			try {
				inSocket.close();
			} catch (IOException e) {
				// TODO: Append to logger that Socket couldn't be closed
				e.printStackTrace();
			}
		}
	}
}
