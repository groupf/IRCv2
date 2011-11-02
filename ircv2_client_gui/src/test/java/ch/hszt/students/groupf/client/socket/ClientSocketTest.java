package ch.hszt.students.groupf.client.socket;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ClientSocketTest {

	private SocketClientConsumer clientConsumer = mock(SocketClientConsumer.class);
	private ClientSocket _clientSocket;
	private final Socket _socket = mock(Socket.class);
	private final DataOutputStream _dos = mock(DataOutputStream.class);
	private final DataInputStream _dis = mock(DataInputStream.class);
	private static InetAddress _localhost;
	private final int _serverPort = 10000;
	private final String _userName = "TestUser";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		_localhost = Inet4Address.getLocalHost();
		// clientConsumer = mock(SocketClientConsumer.class);
		// _socket = mock(Socket.class);
		// _dos = mock(DataOutputStream.class);
		// _dis = mock(DataInputStream.class);
		_clientSocket = new ClientSocket(clientConsumer) {
			@Override
			Socket getNewSocket(InetAddress inServerAddress, int inServerPort) throws IOException,
					IllegalArgumentException {
				if (inServerPort < 0)
					throw new IllegalArgumentException("inServerPort must be greater or equals 0");
				return _socket;
			}

			@Override
			DataOutputStream getNewDataOutputStream(Socket inSocket) throws IOException {
				return _dos;
			}

			@Override
			DataInputStream getNewDataInputStream(Socket inSocket) throws IOException {
				return _dis;
			}
		};

		// when(_clientSocket.getNewSocket(_localhost,
		// _serverPort).thenReturn(_socket);
		// when(_clientSocket.getNewDataInputStream((Socket)
		// anyObject())).thenReturn(_dis);
		// when(_clientSocket.getNewDataOutputStream((Socket)
		// anyObject())).thenReturn(_dos);
		// _clientSocket.setClientSocket(_socket);
		// _clientSocket.setClientDataOut(_dos);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testClientSocketConstructor() {
		try {
			new ClientSocket(null);
			fail("not null param");
		} catch (IllegalArgumentException e) {
			// expected
			assertTrue(e.getMessage().contains("null"));

		}
		SocketClientConsumer clientConsumer = mock(SocketClientConsumer.class);
		ClientSocket clientSocket = new ClientSocket(clientConsumer);
	}

	@Test
	public void testConnectInvalidPort() throws Exception {

		try {
			_clientSocket.connect(_localhost, -1, _userName);
			fail("not null param");
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().contains("Port"));
		}

	}

	// @Test
	// public void testOnDisconnectedCallBack() throws Exception {
	//
	// // when(_dis.readUTF()).thenThrow(new IOException());
	// doThrow(new IOException()).when(_dis).readUTF();
	// _clientSocket.connect(_localhost, _serverPort, _userName);
	// // when(_clientSocket.getNewSocket((InetAddress) anyObject(),
	// // anyInt())).thenReturn(_socket);
	// // when(_clientSocket.getNewDataInputStream(_socket)).thenReturn(_dis);
	// // when(_clientSocket.getNewDataOutputStream(_socket)).thenReturn(_dos);
	//
	// verify(clientConsumer).onDisconnected((Exception) anyObject());
	// // when(clientConsumer.onDisconnected("first").thenReturn("first"));
	// }

	@Test
	public void testSendMsg() throws Exception {
		// when(_clientSocket.getNewSocket((InetAddress) anyObject(),
		// anyInt())).thenReturn(_socket);
		// when(_clientSocket.getNewDataInputStream((Socket)
		// anyObject())).thenReturn(_dis);
		// when(_clientSocket.getNewDataOutputStream((Socket)
		// anyObject())).thenReturn(_dos);

		_clientSocket.connect(_localhost, _serverPort, _userName);
		// when(_clientSocket.getNewSocket(Inet4Address.getLocalHost(),
		// 10000)).thenReturn(_socket);
		// when(_clientSocket.getNewDataInputStream(_socket)).thenReturn(_dis);
		// when(_clientSocket.getNewDataOutputStream(_socket)).thenReturn(_dos);
		// when(_clientSocket.setClientDataOut(anyObject()));
		// DataOutputStream os = null;
		// when(_socket.getOutputStream()).thenReturn(os);
		_clientSocket.sendMsg("Test");
		// assertTrue(os.);
		verify(_dos).writeUTF("Test");
	}
}
