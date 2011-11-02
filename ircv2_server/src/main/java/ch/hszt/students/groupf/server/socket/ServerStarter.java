package ch.hszt.students.groupf.server.socket;

import ch.hszt.students.groupf.server.srvconfig.ServerDefaultConfig;

/**
 * The Class ServerStarter starts the SocketServer. To start the Server start
 * this compiled .JAR File with the preferred TCP-Port on which the Server
 * should listen.
 * 
 * e.g.: To start the Server on Listening-Port 10550 >java -jar
 * ServerStarter.jar 90100
 * 
 * @author Renato Estermann
 * 
 */
public class ServerStarter {
	public static void main(String[] args) {
		int serverPort = getServerPortToStart(args);

		new SocketServer(serverPort);

	}

	private static int getServerPortToStart(String[] args) {
		int serverPort = ServerDefaultConfig.SERVERPORT;

		// TODO eventually replace with BufferedReader from Config File
		if (args.length != 0) {
			try {

				serverPort = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				// TODO: Append to logger output that the default Serverport
				// will be used:

			}
		}
		return serverPort;
	}
}
