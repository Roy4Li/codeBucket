package org.roy.lessons.HFJ;

import java.rmi.Naming;

public class Client {

	public static void main(String[] args) {
		try {
			MyRemote server = (MyRemote)Naming.lookup("Hello");
			System.out.println(server.sayHello());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
