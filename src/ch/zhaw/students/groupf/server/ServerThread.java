package ch.zhaw.students.groupf.server;

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
		
	}

}
