package ch.hszt.students.groupf.client.controller;

import ch.hszt.students.groupf.client.socket.SocketClientConsumerIfc;

public interface UserInterfaceIfc extends SocketClientConsumerIfc {
	public void displayConnStatus(String connectionStatus);
}
