package org.roy.lessons.HFJ;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImp extends UnicastRemoteObject implements MyRemote {

	protected MyRemoteImp() throws RemoteException {
	}

	public String sayHello() throws RemoteException {
		return "Server says : " + "HelloRMI";
	}
	
	public static void main(String[] args) {
		try {
			MyRemote service = new MyRemoteImp();
			Naming.rebind("Hello", service);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
