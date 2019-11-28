package com.example.CarPoolApp;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://localhost/EMP";
	private final String USERNAME = "user";
	private final String PASSWORD = "password";
	private Connection connection;

	public DatabaseConnection() {
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();// Programmer stuff.
			System.out.println("Failed to connect to database!");
			// TODO Do something.
		}
	}

	public Connection getConnection() {
		return connection;
	}
}
