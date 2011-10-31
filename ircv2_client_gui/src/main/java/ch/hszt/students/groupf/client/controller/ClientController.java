package ch.hszt.students.groupf.client.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import ch.hszt.students.groupf.client.gui.ChatClientGUI;
import ch.hszt.students.groupf.client.socket.ChatClient;
import ch.hszt.students.groupf.client.socket.ClientSocket;
import ch.hszt.students.groupf.client.socket.SocketClientConsumer;

public class ClientController implements SocketClientConsumer {

	private ChatClient _chatClient;
	private ChatClientGUI _gui;

	public ClientController() {
		_chatClient = new ClientSocket(this);

		_gui = new ChatClientGUI(this);

		_gui.setVisible(true);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO check wether cmd-line or swing gui
		new ClientController();

	}

	public void onDisconnected(Exception inEx) {
		// TODO Auto-generated method stub

	}

	public void onReceivedMsg(String inMessage) {
		_gui.onReceivedMsg(inMessage);

	}

	public void connect(InetAddress serverAddress, int serverPort,
			String username) {

		try {
			_chatClient.connect(serverAddress, serverPort, username);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void send(String message) {
		try {
			_chatClient.sendMsg(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
