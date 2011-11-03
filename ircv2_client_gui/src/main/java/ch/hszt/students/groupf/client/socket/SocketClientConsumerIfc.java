package ch.hszt.students.groupf.client.socket;

public interface SocketClientConsumerIfc {

	public void onDisconnected(Exception inEx);
	public void onReceivedMsg(String inMessage);
	
}
