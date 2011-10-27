package ch.hszt.students.groupf.server.msgparser;

public class MsgParser {

	public static final String _sendToIndicator = "/";

	// public static final String _cmdIdentifier = "\\";

	public static boolean isForSecificUser(String inMessage) {
		return inMessage.startsWith(_sendToIndicator);
	}

	public static String getRecipientFromMsg(String inMessage) {
		if (isForSecificUser(inMessage)) {
			String recipientUsername = "";

			recipientUsername += inMessage.replaceFirst("^" + _sendToIndicator,
					"");
			recipientUsername = recipientUsername.replaceFirst("\\p{Blank}.*",
					"");
			return recipientUsername;

		}
		return "";
	}

	public static String getMsgPartFromMsg(String inMessage) {
		if (!isForSecificUser(inMessage)) {
			return inMessage;
		}

		String msgPart = "";
		if (!inMessage.contains(" ")) {
			return msgPart;
		}

		msgPart += inMessage.replaceFirst("^" + _sendToIndicator, "");

		msgPart = msgPart.replaceFirst("\\S*\\p{Blank}", "");

		return msgPart;
	}
}
