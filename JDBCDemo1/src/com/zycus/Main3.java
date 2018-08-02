package com.zycus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main3 {
	private static final String CREATE_QUERY = "CREATE TABLE EMP2(EMPID INT PRIMARY KEY, ENAME VARCHAR(20), DESG VARCHAR(20))";

	public static void main(String[] args) {
		try (Connection con = ConnectionUtil.getConnection("org.apache.derby.jdbc.ClientDriver",
				"jdbc:derby://localhost:1527/sample", "user", "pass")) {
			Statement st = con.createStatement();
			con.setAutoCommit(false);
			System.out.println("Before OP");
			readEmp(st);

			deleteEmp(st);
			System.out.println("After OP");
			readEmp(st);

			con.rollback();
			System.out.println("After Rollback");
			readEmp(st);

			con.commit();
			st.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void readEmp(Statement st) throws SQLException {
		ResultSet rs = st.executeQuery("select * from emp");
		while (rs.next()) {
			System.out.print("Record found: ");
			System.out.println(rs.getString("ename"));
		}
	}

	private static void deleteEmp(Statement st) throws SQLException {
		int n = st.executeUpdate("delete from emp");
		System.out.println("Deleted rows: " + n);

	}

}
