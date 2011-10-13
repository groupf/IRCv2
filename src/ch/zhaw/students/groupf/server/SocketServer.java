package ch.zhaw.students.groupf.server;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.HashMap;


public class SocketServer {

	private ServerSocket _serverSocket;
	private HashMap<User, DataOutputStream> _openOutputStreams = new HashMap<User, DataOutputStream>();

	public SocketServer(int inServerPort){

		listen(inServerPort);
	}


	private void listen(int inServerPort) {

		try {
			_serverSocket = new ServerSocket(inServerPort);
		} catch (IOException e) {
			// TODO User slf4j as Log-Appender for the server-log
			e.printStackTrace();
		}


		while (true) {
			BufferedReader reader = null;
			PrintWriter writer = null;

			Socket singleSocket;
			try {
				singleSocket = _serverSocket.accept();
				reader = new BufferedReader(new InputStreamReader(singleSocket.getInputStream()));

				User user = new User(reader.readLine());

				DataOutputStream doutStream = new DataOutputStream(singleSocket.getOutputStream());

				_openOutputStreams.put(user, doutStream);


				new ServerThread(this, singleSocket);

			} catch (IOException e) {
				// TODO Handle IOException
				e.printStackTrace();
			}catch (IllegalArgumentException e) {
				// TODO: Handle IllegalArgumentException (change to IllegalUsernameException)
				e.printStackTrace();
			}

		}
	}

	protected void sendToAll(String inMessage) {
		synchronized (_openOutputStreams) {

		}
	}
	protected void sendToSpecificUser(User inRecipient, String inMessage){
		synchronized (_openOutputStreams) {

		}
	}
}
