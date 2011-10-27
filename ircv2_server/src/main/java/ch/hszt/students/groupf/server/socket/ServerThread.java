package ch.hszt.students.groupf.server.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerThread extends Thread {
	
	private SocketServer _server;
	private Socket _socket;
	private String _socketUserName;
	
	
	public ServerThread(SocketServer inServer, Socket inSocket, String inSocketUserName) {
		// TODO Auto-generated constructor stub
		_server = inServer;
		_socket = inSocket;
		_socketUserName = inSocketUserName;
		
	}
	
	public void run() {

		_server.sendJoinedMsg(_socketUserName);
		try {
			DataInputStream dInStream = new DataInputStream(_socket.getInputStream());
			
			while(true){
				String message = dInStream.readUTF();
				
				//TODO Appender for Message-Logger with Unknown User Exception Handler
				
				//TODO Message Parser for IF-Condition sendToSpecificUser
				
				_server.sendToAll(message, _socketUserName);
//				System.out.println(message);
			}
		} catch (IOException e) {
			// TODO Handle Exception for getInputSteram
			e.printStackTrace();
		}
		
	}

}
