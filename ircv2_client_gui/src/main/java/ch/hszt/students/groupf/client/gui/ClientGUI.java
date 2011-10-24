package ch.hszt.students.groupf.client.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import ch.hszt.students.groupf.client.socket.ClientSocket;
import ch.hszt.students.groupf.client.socket.ClientSocketConnector;
import ch.hszt.students.groupf.client.socket.SocketClientConsumer;
import ch.hszt.students.groupf.data.srvconfig.ServerDefaultConfig;


public class ClientGUI implements SocketClientConsumer{
//public class ClientGUI {	
	private JFrame _frame;
	private JMenuBar _menubar;
	private JMenu _menuConnect;
	private JMenuItem _menuItemOpenCon;
	private JMenuItem _menuItemCloseCon;
	private JTextArea _txArea, _rxArea;
//	private JTextArea _txArea; 
//	private static JTextArea _rxArea;
	private JPanel _panelNorth, _paneCenter, _paneSouth;
	private JLabel _connectionLabel;
	private JScrollPane _scrollPaneRX, _scrollPaneTX;
	private JButton _sendMsgBtn;
	private ClientSocketConnector _clientSocket;
	
	public ClientGUI(){
		createFrame();
	}
	
	private void createFrame() {
		_frame = new JFrame("ChatGUI");
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.setLayout(new BorderLayout());
		_connectionLabel = new JLabel(" ");
//		fileLabel.setSize(frame.WIDTH, 30);
		
		_panelNorth = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		panelNorth.setSize(frame.WIDTH, 30);
		_panelNorth.add(_connectionLabel);
		
		createMenuBar();
		
		_rxArea = new JTextArea();
		_rxArea.setEditable(false);
		_rxArea.setLineWrap(true);
		
		_txArea = new JTextArea();
		_scrollPaneTX = new JScrollPane(_txArea);
		_scrollPaneRX = new JScrollPane(_rxArea);
		
		
		_paneCenter = new JPanel(new GridLayout(2, 1));
		_paneCenter.add(_scrollPaneRX);
		_paneCenter.add(_scrollPaneTX);

		_sendMsgBtn = new JButton("Send");
		_sendMsgBtn.addActionListener(new SendMsgActionListener());
		_paneSouth = new JPanel(new FlowLayout());
		_paneSouth.add(_sendMsgBtn);
				
		_frame.add(BorderLayout.NORTH,_panelNorth);
		_frame.add(BorderLayout.CENTER,_paneCenter);
		_frame.add(BorderLayout.SOUTH, _paneSouth);
		
		
		_frame.setSize(800, 600);
		_frame.setVisible(true);
		
	}

	private void createMenuBar() {
		_menubar = new JMenuBar();
		_frame.setJMenuBar(_menubar);
		
		_menuConnect = new JMenu("Connection");
		_menubar.add(_menuConnect);
		
		_menuItemOpenCon = new JMenuItem("Open Connection");
		_menuItemOpenCon.addActionListener(new OpenConActionListener());
		_menuConnect.add(_menuItemOpenCon);
		
		_menuItemCloseCon = new JMenuItem("Close Connection");
		_menuItemCloseCon.addActionListener(new CloseConActionListener());
		_menuConnect.add(_menuItemCloseCon);
		
	}
	
	private class OpenConActionListener implements ActionListener{

		
		public void actionPerformed(ActionEvent arg0) {
			String userName = "rest";
			
			_clientSocket = new ClientSocket(ClientGUI.this, "127.0.0.1", ServerDefaultConfig.SERVERPORT, userName );
//			_clientSocket = new ClientSocket("127.0.0.1", ServerDefaultConfig.SERVERPORT );
			
			try {
				_clientSocket.openConnection();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 
				e.printStackTrace();
			}
//			echoServer.startEchoServer(14000);
//			_connectionLabel.setText(_clientSocket.getConnectionInfo());
			
//			try {
//				clientSocket.openSocket(Inet4Address.getLocalHost(), 14000);
//			} catch (UnknownHostException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			
			
			// TODO Auto-generated method stub
//			JLabel lblServerIP = new JLabel("Server IP:");
//			JLabel lblServerPort = new JLabel("Server Port:");
//			JTextField txtServerIP = new JTextField(15);
//			JTextField txtServerPort = new JTextField(15);
//			SpringLayout layout = new SpringLayout();
//			JPanel tempPanel = new JPanel(layout);
//			lblServerIP.setLabelFor(txtServerIP);
//			lblServerPort.setLabelFor(txtServerPort);
//			tempPanel.setSize(30, 30);
//			tempPanel.add(lblServerIP);
//			tempPanel.add(txtServerIP);
//			tempPanel.add(lblServerPort);
//			tempPanel.add(txtServerPort);
//			
//			JOptionPane.showInputDialog(frame,JOptionPane.OK_CANCEL_OPTION);
//			new ConGUI();
			
			
			
//			tempPanel.setLayout(layout);
			
		}
		
	}
	private class CloseConActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}

		
	}

	private class SendMsgActionListener implements ActionListener{

	
		public void actionPerformed(ActionEvent arg0) {
			//TODO Handle NullPointerException when no ClientSocket was opened first (_clientSocket ==Null)
			try {
				_clientSocket.sendMsg(_txArea.getText());
			} catch (IOException e) {
				// TODO Hanlde IOException when message could not be sent
				e.printStackTrace();
			}
			
			_txArea.setText("");
			
		}
		
	}

	public void onDisconnected() {
		// TODO Handle Disconnect call from the ClientSocket Thread
		
	}

	public void onReceivedMsg(String inMessage) {
		_rxArea.append(inMessage);
		
	}
}
