package ch.hszt.students.groupf.server.msgparser;

public class MsgParser {

	public static final String _sendToIndicator = "/";

	// public static final String _cmdIdentifier = "\\";

	public static boolean isForSecificUser(String inMessage) {
		return inMessage.startsWith(_sendToIndicator);
	}

	public static String getRecipientUsername(String inMessage) {
		return "";
	}
}
