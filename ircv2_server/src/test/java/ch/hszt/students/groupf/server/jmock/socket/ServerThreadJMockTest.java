package ch.hszt.students.groupf.server.jmock.socket;

import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ch.hszt.students.groupf.server.socket.ServerThread;

public class ServerThreadJMockTest {

	Mockery _socketServer;
	Mockery _socket;
	String _socketUsername;
	ServerThread _serverThread;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		_socketServer = new JUnit4Mockery();
		_socket = new JUnit4Mockery();
		_socketUsername = "TestUser";

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRun() {
		// fail("Not yet implemented");
	}

	@Test
	public void testServerThread() {

		// fail("Not yet implemented");
	}

}
