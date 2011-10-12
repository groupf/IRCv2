package ch.zhaw.students.groupf.server;
import java.io.IOException;
import java.net.*;
import java.util.HashMap;


public class SocketServer {

	private ServerSocket _serverSocket;
	private HashMap<String, Socket> openSockets = new HashMap<String, Socket>();
	
	public SocketServer(int inServerPort) throws IOException{
	
		listen(inServerPort);
	}
	
	private void listen(int inServerPort) throws IOException{
		_serverSocket = new ServerSocket(inServerPort);
		
		
		while (true) {
			Socket singleServerSocket = _serverSocket.accept();
			
			
			
		}
	}
}
