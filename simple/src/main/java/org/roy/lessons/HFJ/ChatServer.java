package org.roy.lessons.HFJ;
import java.net.*;
import java.util.*;
import java.io.*;

public class ChatServer {
	
	public static String SERVER_IP = "127.0.0.1";
	public static int SERVER_PORT = 5666;
	
	private ArrayList<Socket> clientSockList;
	
	public void go(){
		
		clientSockList = new ArrayList<Socket>();
		
		try {
			ServerSocket serverSock = new ServerSocket(SERVER_PORT);
			while(true){
				Socket clientSock = serverSock.accept();
				System.out.println("Got a new client\n" + clientSock.toString() );
				Thread newThread = new Thread(new ServerProcess(clientSock));
				newThread.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public class ServerProcess implements Runnable{
		private Socket selfSock;
		private PrintWriter writer ;
		private BufferedReader reader;
		private InputStreamReader in;
		public void run() {
			while(true){
				try {
					String str = reader.readLine();
					for (Socket sock:clientSockList ){
						writer = new PrintWriter(sock.getOutputStream());
						writer.println(str);
						writer.flush();
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public ServerProcess(Socket sock){
			clientSockList.add(sock);
			this.selfSock = sock;
			
			try {
				in = new InputStreamReader(sock.getInputStream());
				reader = new BufferedReader(in);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

	public static void main(String[] args) {
		ChatServer server = new ChatServer();
		System.out.println("Server Started");
		server.go();
	}

}
