package org.roy.lessons.HFJ;

import java.io.*;
import java.net.*;

public class ChatClient {
	
	Socket selfSock;
	private PrintWriter writer ;
	private BufferedReader reader;
	private InputStreamReader in;
	
	public void go(){
		buildGUI();
		Socket sock;
		try {
			sock = new Socket(ChatServer.SERVER_IP,ChatServer.SERVER_PORT);
			in = new InputStreamReader(sock.getInputStream());
			reader = new BufferedReader(in);
			writer = new PrintWriter(sock.getOutputStream());
			System.out.println("Connect to server ok\n" + sock.toString());
			Thread t = new Thread(new InboxHandler());
			t.start();
			this.selfSock = sock;
			while(true){
				writer.println("I'm sock " + sock.toString());
				writer.flush();
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void buildGUI() {
		
	}
	
	public static void main(String[] args) {
		ChatClient client = new ChatClient();
		System.out.println("Client Started");
		client.go();
	}
	
	public class InboxHandler implements Runnable{
		public void run() {
			while(true){
				String str;
				try {
					while((str = reader.readLine()) != null){
						System.out.println("Server Says : " + str);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
