package ch.hszt.students.groupf.client.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocket implements ClientSocketConnector, Runnable{

	private Socket _clientSocket;
	private DataInputStream _clientDataIn;
	private DataOutputStream _clientDataOut;
	
	//TODO Change _serverAddress to InetAddress or Inet4Address
	private String _serverAddress;
	//TODO Change _serverPort to a Port-Class
	private int _serverPort;
	
	public ClientSocket(String inServerAddress, int inServerPort) {
		// TODO ServerAddress and ServerPort Validation with Exception throw
		_serverAddress = inServerAddress;
		_serverPort = inServerPort;
	}
	
	public void openConnection() throws UnknownHostException, IOException{
		
		_clientSocket = new Socket(_serverAddress, _serverPort);
		//TODO Appender to the Log, that the Socket was opened 
		
		_clientDataIn = new DataInputStream(_clientSocket.getInputStream());
		_clientDataOut = new DataOutputStream(_clientSocket.getOutputStream());

		new Thread(this).start();
		
		
	}
	
	
	public void sendMsg(String inMessage) throws IOException{
		// TODO implement the sendMsg Method
		_clientDataOut.writeUTF(inMessage);
		
	}
	
	public void sendMsgTo(String message) throws IOException{
		// TODO implement the sendMsgTo Method
		
	}

	public void run(){
		
		while(true){
			try {
				String message = _clientDataIn.readUTF();
			} catch (IOException e) {
				// TODO implement onDisconnected in GUI and call if exception
				e.printStackTrace();
			}
			
			
		}
		
	}
}
