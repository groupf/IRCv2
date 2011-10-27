package ch.hszt.students.groupf.server.junit.msgparser;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ch.hszt.students.groupf.server.msgparser.MsgParser;

public class MsgParserJunitTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsForSecificUser() {

		assertTrue(MsgParser.isForSecificUser("/asdfwwe"));
		assertTrue(MsgParser.isForSecificUser("/ Hallo"));
		assertFalse(MsgParser.isForSecificUser("Hallo Test"));

	}

	@Test
	public void testGetRecipientUsername() {

	}

}
