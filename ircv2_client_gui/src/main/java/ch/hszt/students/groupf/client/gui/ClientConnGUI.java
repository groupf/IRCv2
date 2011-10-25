package ch.hszt.students.groupf.client.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class ClientConnGUI {
	private JFrame _frame = new JFrame("Connection");
	private JLabel _lblUserName = new JLabel("User Name:", JLabel.CENTER);
	private JLabel _lblServerIP = new JLabel("Server IP:", JLabel.CENTER);
	private JLabel _lblServerPort = new JLabel("Server Port:",JLabel.CENTER);
	private JTextField _txtUserName = new JTextField(15);
	private JTextField _txtServerIP = new JTextField(15);
	private JTextField _txtServerPort = new JTextField(15);
//	SpringLayout layout = new SpringLayout();
	private JPanel _gridPanel = new JPanel(new GridLayout(4,2,2,1));
	private JPanel _mainPanel = new JPanel(new BorderLayout());
	private JPanel _btnPanel = new JPanel(new FlowLayout());
	private JButton _btnConnect = new JButton("Connect");
	private JButton _btnCancel = new JButton("Cancel");



//	 
//	        //Lay out the panel.
//	        SpringUtilities.makeCompactGrid(p,
//	                                        numPairs, 2, //rows, cols
//	                                        6, 6,        //initX, initY
//	                                        6, 6);       //xPad, yPad
//	 
//	        //Create and set up the window.
//	        JFrame frame = new JFrame("SpringForm");
//	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	 
//	        //Set up the content pane.
//	        p.setOpaque(true);  //content panes must be opaque
//	        frame.setContentPane(p);
//	 

	
	public ClientConnGUI() {
		// TODO Auto-generated constructor stub
		createFrame();
	}
	
	private void createFrame(){
		_gridPanel.add(_lblUserName);
		_lblUserName.setLabelFor(_txtUserName);
		_gridPanel.add(_txtUserName);
		_gridPanel.add(_lblServerIP);
		_lblServerIP.setLabelFor(_txtServerIP);
		_gridPanel.add(_txtServerIP);
		_gridPanel.add(_lblServerPort);
		_lblServerPort.setLabelFor(_txtServerPort);
		_gridPanel.add(_txtServerPort);		
//		_gridPanel.setSize(30, 30);
//		
//	    Container cp = getContentPane();
//	    cp.add(p, BorderLayout.NORTH);
//	    JButton b = new JButton("go");
//	    b.addActionListener(new BL());
//	    cp.add(b, BorderLayout.SOUTH);
//		
		_btnPanel.add(_btnConnect);
		_btnPanel.add(_btnCancel);
		
		_mainPanel.add(_gridPanel, BorderLayout.CENTER);
		_mainPanel.add(_btnPanel, BorderLayout.SOUTH);
		
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		_gridPanel.setOpaque(true);
		_frame.setContentPane(_mainPanel);
		
		_frame.pack();
		_frame.setVisible(true);
		
	}
}
