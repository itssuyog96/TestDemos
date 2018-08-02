package com.zycus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Main2 {
	private static final String CREATE_QUERY = "CREATE TABLE EMP2(EMPID INT PRIMARY KEY, ENAME VARCHAR(20), DESG VARCHAR(20))";

	public static void main(String[] args) {
		try (Connection con = ConnectionUtil.getConnection("org.apache.derby.jdbc.ClientDriver",
				"jdbc:derby://localhost:1527/sample", "user", "pass")) {
			Statement st = con.createStatement();
			st.execute(CREATE_QUERY);
			st.close();

			// Prepared Statement with Positional parameters (Max 9)
			PreparedStatement ps = con.prepareStatement("INSERT INTO EMP2 VALUES(?, ?, ?)");
			ps.setInt(1, 101);
			ps.setString(2, "Rahul Gandhi");
			ps.setString(3, "President");

			int rows = ps.executeUpdate();
			System.out.println("Recored added: " + rows);
			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
