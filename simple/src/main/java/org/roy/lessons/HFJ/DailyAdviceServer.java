package org.roy.lessons.HFJ;

import java.io.*;
import java.net.*;

public class DailyAdviceServer extends DailyAdviceProtocol {

	private String[] adviceList = { "Take a shower", "Eat a cake",
			"Read a book","Hava a sex","Go to bed","Hava a drink",
			"Call you mom"};

	public void go() {
		try {
			ServerSocket serverSock = new ServerSocket(SERVER_PORT);
			System.out.println("Server started");
			while (true) {
				Socket sock = serverSock.accept();
				int cnt = 1;
				InputStreamReader in = new InputStreamReader(sock.getInputStream());
				BufferedReader reader = new BufferedReader(in);
				PrintWriter writer = new PrintWriter(sock.getOutputStream());

				System.out.println("Got client socket: " + sock.toString());

				while (true) {
					String request = null;
					String response = null;

					if (reader.ready()) {
						if ((request = reader.readLine()) != null) {
							System.out.println("Got client request: " + request
									+ " @cnt=" + (cnt++));
							if (request.equals(RQ_CLOSE)) {
								writer.println(RS_CLOSE);
								writer.flush();
								break;
							} else if (request.equals(RQ_ADVICE)) {
								writer.println(getAdvice());
								writer.flush();
							} else {
								writer.println("unknown request");
								writer.flush();
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getAdvice() {
		int index = (int) (Math.random() * adviceList.length);
		return adviceList[index];
	}

	public static void main(String[] args) {
		DailyAdviceServer server = new DailyAdviceServer();
		server.go();
	}

}
