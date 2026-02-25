package org.example.byteByteGo.solid.dip;

public class UserService {
	private Database database;

	public UserService(Database database) {
		this.database = database;
	}

	public void saveUser(String user) {
		database.save(user);
	}
}
