package ch.hszt.students.groupf.client.cli;

import ch.hszt.students.groupf.client.socket.SocketClientConsumer;

public class ClientCLI implements SocketClientConsumer {
	private boolean _exit = false;
	
	public ClientCLI() {
		runSubshell();
	}

	private void runSubshell(){
		
		while (!_exit) {
			welcomeMsg();
//			String inText = System.in;
			
			
		}
		
		
	}
	
	private void welcomeMsg(){
		System.out.println("Welcome to the CLI-Chat Client IRCv2"+ System.getProperty("line.separator"));
		//TODO print out the help (possible commands)
	}
	
	public void onDisconnected() {
		// TODO Auto-generated method stub

	}

	public void onReceivedMsg(String inMessage) {
		// TODO Auto-generated method stub

	}

}
