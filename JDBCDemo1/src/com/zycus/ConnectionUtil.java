package com.zycus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public static Connection getConnection(String driver, String url, String user, String pass) {

		// Step 1: Load JDBC Driver class

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Step2: Establish connection
		Connection con;
		try {
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("Esatblishing connection with " + con.getMetaData().getDatabaseProductName());
			return con;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Unable to Connect! " + e.getMessage());
			return null;
		}

	}
}
