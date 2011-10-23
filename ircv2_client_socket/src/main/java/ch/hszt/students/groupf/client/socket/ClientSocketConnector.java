package ch.hszt.students.groupf.client.socket;

import java.io.IOException;
import java.net.UnknownHostException;

public interface ClientSocketConnector{
	public void openConnection() throws UnknownHostException, IOException;
	public void sendMsg(String message) throws IOException;
	public void sendMsgTo(String message) throws IOException;
 
}
