package com.example.CarPoolApp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseQuery {
	/*
	 * https://docs.oracle.com/javase/tutorial/jdbc/basics/processingsqlstatements.
	 * html In general, to process any SQL statement with JDBC, you follow these
	 * steps: Establishing a connection. Create a statement. Execute the query.
	 * Process the ResultSet object. Close the connection.
	 */

	private DatabaseConnection databaseConnection;
	private Connection connection;
	private Statement queryStatement;

	public DatabaseQuery() {
		try {
			databaseConnection = new DatabaseConnection();
			connection = databaseConnection.getConnection();
		} catch (Exception e) {
			e.printStackTrace();// Programmer stuff.
			System.out.println("Failed to connection to database!");
			// TODO do something.
		}
	}

	public String sendRemoveQuery(String query) {
		// TODO
	}

	public String sendSaveQuery(String query) {
		// TODO
	}

	public ResultSet sendQuery(String query) {
		ResultSet result = null;
		try {
			queryStatement = connection.createStatement();
			result = queryStatement.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();// Programmer stuff.
			// TODO do something.
		}
		return result;
	}
}
