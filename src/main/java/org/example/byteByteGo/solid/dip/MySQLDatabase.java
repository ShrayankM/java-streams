package org.example.byteByteGo.solid.dip;

public class MySQLDatabase implements Database {

	@Override
	public void save(String data) {
		System.out.println("Saving to MySQL");
	}
}
