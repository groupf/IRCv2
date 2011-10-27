package ch.hszt.students.groupf.client.socket;

public interface SocketClientConsumer {

	public void onDisconnected(Exception inEx);
	public void onReceivedMsg(String inMessage);
	
}
