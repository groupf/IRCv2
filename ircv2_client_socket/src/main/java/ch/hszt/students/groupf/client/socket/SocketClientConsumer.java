package ch.hszt.students.groupf.client.socket;

public interface SocketClientConsumer {

	public void onDisconnected();
	public void onReceivedMsg(String inMessage);
	
}
