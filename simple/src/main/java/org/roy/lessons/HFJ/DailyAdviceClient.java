package org.roy.lessons.HFJ;

import java.io.*;
import java.net.*;

public class DailyAdviceClient extends DailyAdviceProtocol {

	public void go() {
		try {
			Socket sock = new Socket(SERVER_IP, SERVER_PORT);

			PrintWriter writer = new PrintWriter(sock.getOutputStream());
			InputStreamReader in = new InputStreamReader(sock.getInputStream());
			BufferedReader reader = new BufferedReader(in);
			System.out.println(sock.toString());
			String res = null;
			int state = 0;
			int cnt = 0;
			while (true) {
				switch (state) {
				case 0:
					writer.println(RQ_ADVICE);
					writer.flush();
					cnt++;
					if (cnt >= 10) {
						cnt = 0;
						state++;
					}
					break;

				case 1:
					writer.println("Hello");
					writer.flush();
					state++;
					break;
				
				case 2:
					writer.println(RQ_CLOSE);
					writer.flush();
				default:
					break;
				}
				if (reader.ready()) {
					if ((res = reader.readLine()) != null) {
						System.out.println("Server says : " + res);
						if (res.equals(RS_CLOSE)) {
							writer.close();
							sock.close();
							System.out.println("Shutdown connection");
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DailyAdviceClient client = new DailyAdviceClient();
		client.go();
	}
}
