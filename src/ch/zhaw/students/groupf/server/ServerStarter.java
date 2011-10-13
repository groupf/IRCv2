package ch.zhaw.students.groupf.server;

import java.io.IOException;

public class ServerStarter {
	public static void main(String[] args){
		
		//TODO eventually replace with BufferedReader from Config File or Java-Class in .groupf.data
		int serverPort = Integer.parseInt(args[0]);
		
		new SocketServer(serverPort);
		
	}
}
