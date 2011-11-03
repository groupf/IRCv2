package ch.hszt.students.groupf.server.msgparser;

import junit.framework.TestCase;
import ch.hszt.students.groupf.server.msgparser.MsgParser;

public class MsgParserJunitTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testIsForSecificUser() {

		assertTrue(MsgParser.isForSecificUser("/asdfwwe"));
		assertTrue(MsgParser.isForSecificUser("/ Hallo"));
		assertFalse(MsgParser.isForSecificUser("Hallo Test"));
		assertFalse(MsgParser.isForSecificUser("\\user hello"));
		assertFalse(MsgParser.isForSecificUser("\\user"));
	}

	public void testGetRecipientUsername() {
		assertEquals(
				"testUser",
				MsgParser
						.getRecipientFromMsg("/testUser Ab hier kommt die Meldung"));

		assertEquals("testUserAbhierkommtdieMeldung",
				MsgParser.getRecipientFromMsg("/testUserAbhierkommtdieMeldung"));

		assertEquals("testUser:AbhierkommtdieMeldung",
				MsgParser
						.getRecipientFromMsg("/testUser:AbhierkommtdieMeldung"));
		assertEquals("", MsgParser.getRecipientFromMsg("/"));

		assertEquals(
				"",
				MsgParser
						.getRecipientFromMsg("\testUser Abhier kommt die Meldung"));

	}

	public void testGetMsgPartFromMsg() {

		assertEquals(
				"Ab hier kommt die Meldung",
				MsgParser
						.getMsgPartFromMsg("/testUser Ab hier kommt die Meldung"));

		assertEquals("",
				MsgParser.getMsgPartFromMsg("/testUserAbhierkommtdieMeldung"));

		assertEquals("",
				MsgParser.getMsgPartFromMsg("/testUser:AbhierkommtdieMeldung"));
		assertEquals("", MsgParser.getMsgPartFromMsg("/"));

		assertEquals(
				"\testUser Abhier kommt die Meldung",
				MsgParser
						.getMsgPartFromMsg("\testUser Abhier kommt die Meldung"));

	}
}
