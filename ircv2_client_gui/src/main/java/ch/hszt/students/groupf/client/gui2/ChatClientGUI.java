/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ChatClientGUI.java
 *
 * Created on 27.10.2011, 11:58:27
 */
package ch.hszt.students.groupf.client.gui2;

import java.awt.event.KeyEvent;
import java.net.InetAddress;

import ch.hszt.students.groupf.client.controller.ClientController;

/**
 * 
 * @author rest
 */
public class ChatClientGUI extends javax.swing.JFrame {

	private final ClientController _controller;

	/** Creates new form ChatClientGUI */
	public ChatClientGUI(ClientController inClientController) {
		_controller = inClientController;
		init();
		initComponents();
		setVisible(true);

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTextArea2 = new javax.swing.JTextArea();
		jButton1 = new javax.swing.JButton();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenuItem2 = new javax.swing.JMenuItem();
		jMenu2 = new javax.swing.JMenu();
		jMenuItem3 = new javax.swing.JMenuItem();
		jMenuItem4 = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("IRCv2 Chat Client");

		jTextArea1.setColumns(20);
		jTextArea1.setEditable(false);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		jTextArea2.setColumns(20);
		jTextArea2.setLineWrap(true);
		jTextArea2.setRows(5);
		jTextArea2.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent evt) {
				onKeyPressed(evt);
			}
		});
		jScrollPane2.setViewportView(jTextArea2);

		jButton1.setText("Send");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				onSendActionPerformed(evt);
			}
		});

		jMenu1.setText("Connection");

		jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_Y,
				java.awt.event.InputEvent.CTRL_MASK));
		jMenuItem1.setText("Open Connection");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				onOpenConnection(evt);
			}
		});
		jMenu1.add(jMenuItem1);

		jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_X,
				java.awt.event.InputEvent.CTRL_MASK));
		jMenuItem2.setText("Close Connection");
		jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				onCloseConnection(evt);
			}
		});
		jMenu1.add(jMenuItem2);

		jMenuBar1.add(jMenu1);

		jMenu2.setText("Help");

		jMenuItem3.setText("Commands");
		jMenu2.add(jMenuItem3);

		jMenuItem4.setText("About");
		jMenu2.add(jMenuItem4);

		jMenuBar1.add(jMenu2);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(
														jButton1,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														79,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(
														jScrollPane2,
														javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														612, Short.MAX_VALUE)
												.addComponent(
														jScrollPane1,
														javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														612, Short.MAX_VALUE))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										224,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jScrollPane2,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										219,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jButton1,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										26, Short.MAX_VALUE).addContainerGap()));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void onKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_onKeyPressed
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			if (evt.isControlDown()) {
				jTextArea2.append("\n");
			} else {
				sendMsg();

			}
		}
	}// GEN-LAST:event_onKeyPressed

	private void onSendActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_onSendActionPerformed
		sendMsg();
	}// GEN-LAST:event_onSendActionPerformed

	private void sendMsg() {
		_controller.send(jTextArea2.getText());
		jTextArea2.setText("");

	}

	private void onOpenConnection(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_onOpenConnection
		ChatClientConnGUI clientConnGUI = new ChatClientConnGUI(this, true);
		clientConnGUI.setVisible(true);
		String username = clientConnGUI.getUserName();
		InetAddress serverAddress = clientConnGUI.getServerAddress();
		int serverPort = clientConnGUI.getServerPort();
		if (serverAddress != null) {
			_controller.connect(serverAddress, serverPort, username);
		}
	}// GEN-LAST:event_onOpenConnection

	private void onCloseConnection(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_onCloseConnection
		// TODO add your handling code here:
	}// GEN-LAST:event_onCloseConnection

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void init() {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(ChatClientGUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ChatClientGUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ChatClientGUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ChatClientGUI.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JMenuItem jMenuItem3;
	private javax.swing.JMenuItem jMenuItem4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JTextArea jTextArea2;

	// End of variables declaration//GEN-END:variables

	public void onReceivedMsg(String inMessage) {
		jTextArea1.append(inMessage);

	}
}
