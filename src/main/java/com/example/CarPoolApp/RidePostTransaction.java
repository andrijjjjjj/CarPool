package com.example.CarPoolApp;

import java.sql.ResultSet;
import java.util.ArrayList;

public class RidePostTransaction {
	public static ArrayList<RidePost> getAllRidePosts() {
		DatabaseQuery query;
		String querySQLStatement;
		ArrayList<RidePost> listRidePosts;

		// Create query object
		query = new DatabaseQuery();

		// Prepare sql statement for getting all RidePost objects. EX: SELECT ...
		querySQLStatement = "";// TODO

		// Make query to database for all RidePost objects. Handle resulting ResultSet.
		ResultSet queryResult;
		queryResult = query.sendQuery(querySQLStatement);
		if (queryResult == null) {
			// No ride posts.
			// TODO What to do if theres no ride posts? Just return null? Have UI handle
			// that?
			return null;
		} else {
			listRidePosts = new ArrayList<RidePost>();
			// TODO Loop through all rows of RidePosts, add ID to listRidePosts? Or whole
			// object?

			return listRidePosts;
		}
	}
}
