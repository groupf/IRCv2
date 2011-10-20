package ch.hszt.students.groupf.client.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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


public class ClientGUI{
	
	private JFrame frame;
	private JMenuBar menubar;
	private JMenu menuConnect;
	private JMenuItem menuItemOpenCon;
	private JMenuItem menuItemCloseCon;
	private JTextArea txArea, rxArea;
	private JPanel panelNorth, paneCenter, paneSouth;
	private JLabel connectionLabel;
	private JScrollPane scrollPaneRX, scrollPaneTX;
	private JButton sendMsgBtn;
//	private EchoServer echoServer;
//	private ClientSocket clientSocket;
	
//	@Override
//	
//	public void run() {
//		
//		
//	}
	public ClientGUI(){
		createFrame();
//		echoServer = new EchoServer();
//		clientSocket = new ClientSocket();
	}
	
	private void createFrame() {
		frame = new JFrame("ChatGUI");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		connectionLabel = new JLabel(" ");
//		fileLabel.setSize(frame.WIDTH, 30);
		
		panelNorth = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		panelNorth.setSize(frame.WIDTH, 30);
		panelNorth.add(connectionLabel);
		
		createMenuBar();
		
		rxArea = new JTextArea();
		rxArea.setEditable(false);
		rxArea.setLineWrap(true);
		
		txArea = new JTextArea();
		scrollPaneTX = new JScrollPane(txArea);
		scrollPaneRX = new JScrollPane(rxArea);
		
		
		paneCenter = new JPanel(new GridLayout(2, 1));
		paneCenter.add(scrollPaneRX);
		paneCenter.add(scrollPaneTX);

		sendMsgBtn = new JButton("Send");
		sendMsgBtn.addActionListener(new SendMsgActionListener());
		paneSouth = new JPanel(new FlowLayout());
		paneSouth.add(sendMsgBtn);
				
		frame.add(BorderLayout.NORTH,panelNorth);
		frame.add(BorderLayout.CENTER,paneCenter);
		frame.add(BorderLayout.SOUTH, paneSouth);
		
		
		frame.setSize(800, 600);
		frame.setVisible(true);
		
	}

	private void createMenuBar() {
		menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
		
		menuConnect = new JMenu("Connection");
		menubar.add(menuConnect);
		
		menuItemOpenCon = new JMenuItem("Open Connection");
		menuItemOpenCon.addActionListener(new OpenConActionListener());
		menuConnect.add(menuItemOpenCon);
		
		menuItemCloseCon = new JMenuItem("Close Connection");
		menuItemCloseCon.addActionListener(new CloseConActionListener());
		menuConnect.add(menuItemCloseCon);
		
	}
	
	private class OpenConActionListener implements ActionListener{

		
		public void actionPerformed(ActionEvent arg0) {
			
//			echoServer.startEchoServer(14000);
//			connectionLabel.setText(echoServer.getConnectionInfo());
			
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
			// TODO Auto-generated method stub
			
		}
		
	}
}
