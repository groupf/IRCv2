package ch.hszt.students.groupf.data.msgparser;

public class MsgParser {

	public static final String _sendToIdentifier = "/";
	public static final String _cmdIdentifier = "\\";
	
	public static boolean isForSecificUser(String inMessage){
		return inMessage.startsWith(_sendToIdentifier);
	}
	
	public static String getRecipientUsername(String inMessage){
		return "";
	}
}
