package ch.hszt.students.groupf.server;

import java.io.IOException;

import ch.hszt.students.groupf.data.srvconfig.ServerDefaultConfig;
/**
 * The Class ServerStarter starts the SocketServer. To start the Server start this compiled .JAR File
 * with the prefered TCP-Port on which the Server sould listen.
 * 
 * eg.: To start the Server on Listening-Port 10550
 * >java ServerStarter.jar 90100
 * 
 * @author Renato Estermann
 * 
 */
public class ServerStarter {
	public static void main(String[] args){
		int serverPort = ServerDefaultConfig.SERVERPORT;
		
		//TODO eventually replace with BufferedReader from Config File or Java-Class in .groupf.data
		if(args.length != 0){
			try {
				
				serverPort = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				// TODO: Append to logger output that the default Serverport will be used:
				
			}
		}
				
		
		new SocketServer(serverPort);
		
	}
}
