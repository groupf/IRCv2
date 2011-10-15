package main.ch.zhaw.students.groupf.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerThread implements Runnable {
	
	private SocketServer _server;
	private Socket _socket;
	
	
	public ServerThread(SocketServer inServer, Socket inSocket) {
		// TODO Auto-generated constructor stub
		this._server = inServer;
		this._socket = inSocket;
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			DataInputStream dInStream = new DataInputStream(_socket.getInputStream());
			
			while(true){
				String message = dInStream.readUTF();
				
				//TODO Appender for Message-Logger with Unknown User Exception Handler
				
				//TODO Message Parser for IF-Condition sendToSpecificUser
				
				_server.sendToAll(message);
			}
		} catch (IOException e) {
			// TODO Handle Exception for getInputSteram
			e.printStackTrace();
		}
		
	}

}
