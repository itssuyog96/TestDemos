package com.diksha;

import java.sql.*;

public class loginDOA{
	

	private static final String SQL_SELECT_ID_CUSTOMER = "select pass from Account where id = ?";
	
	
	public boolean findById(int id,int pass) {
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID_CUSTOMER);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			int key=0;
			if (rs.next()) 
				{
				key=rs.getInt(1);
				}
			if(key==pass)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}

	}
	
	

}
