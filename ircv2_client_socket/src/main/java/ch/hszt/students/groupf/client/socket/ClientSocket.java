package ch.hszt.students.groupf.client.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocket implements ChatClient, Runnable {

	private Socket _clientSocket;
	private DataInputStream _clientDataIn;
	private DataOutputStream _clientDataOut;
	private SocketClientConsumer _sktClientConsumer;
	private String _socketUserName;

	// TODO Change _serverAddress to InetAddress or Inet4Address
	private String _serverAddress;
	// TODO Change _serverPort to a Port-Class
	private int _serverPort;

	public ClientSocket(SocketClientConsumer inSktClientConsumer) {
		_sktClientConsumer = inSktClientConsumer;
		// public ClientSocket(String inServerAddress, int inServerPort) {
		// TODO ServerAddress and ServerPort Validation with Exception throw
	}

	public void connect(String inServerAddress, int inServerPort,
			String inUserName) throws UnknownHostException, IOException {

		_serverAddress = inServerAddress;
		_serverPort = inServerPort;
		_socketUserName = inUserName;

		_clientSocket = new Socket(_serverAddress, _serverPort);
		// TODO Appender to the Log, that the Socket was opened

		_clientDataIn = new DataInputStream(_clientSocket.getInputStream());
		_clientDataOut = new DataOutputStream(_clientSocket.getOutputStream());
		_clientDataOut.writeUTF(_socketUserName);

		new Thread(this).start();

	}

	public void sendMsg(String inMessage) throws IOException {
		// TODO implement the sendMsg Method
		_clientDataOut.writeUTF(inMessage);

	}

	public void sendMsgTo(String message) throws IOException {
		// TODO implement the sendMsgTo Method

	}

	public void run() {

		while (true) {
			String message = "";
			try {
				message = _clientDataIn.readUTF();

			} catch (IOException e) {
				if (_clientSocket.isClosed()) {
					_sktClientConsumer.onDisconnected(e);
				}
			}

			_sktClientConsumer.onReceivedMsg(message
					+ System.getProperty("line.separator"));
		}

	}
}
