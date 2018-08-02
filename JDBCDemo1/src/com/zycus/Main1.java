package com.zycus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main1 {
	private static final String SELECT_QUERY = "SELECT EMPID, ENAME, SAL, DEPTID FROM EMP";

	public static void main(String[] args) {

		try (Connection con = ConnectionUtil.getConnection("org.apache.derby.jdbc.ClientDriver",
				"jdbc:derby://localhost:1527/sample", "user", "pass")) {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(SELECT_QUERY);
			while (rs.next()) {
				Employee employee = convertToEmployee(rs);
				System.out.println(employee);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static Employee convertToEmployee(ResultSet rs) throws SQLException {
		return new Employee(rs.getInt("EMPID"), rs.getString("ENAME"), rs.getFloat("SAL"), rs.getInt("DEPTID"));
	}
}
