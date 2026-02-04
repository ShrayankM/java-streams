package org.example.proxy;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteServiceImpl extends UnicastRemoteObject implements RemoteService {
	protected RemoteServiceImpl() throws RemoteException {}

	@Override
	public String sayHello() throws RemoteException {
		return "Hello from the remote service implementation";
	}

	public static void main(String [] args) {
		try {
			RemoteService remoteService = new RemoteServiceImpl();
			Naming.bind("RemoteServiceHello", remoteService);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
