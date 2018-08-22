package com.diksha;

import java.sql.*;
import java.util.*;

public class ADDAccDOA implements CommonDAO<Customer> {
	
	private List<Customer> cardlist = new ArrayList<Customer>();
	private static final String SQL_SELECT_ID_CUSTOMER = "select * from Customer where id = ?";
	private static final String INSERT_CUSTOMER = "INSERT INTO Customer(title, firstname, lastname, Age, DOB,PAN) values(?, ?, ?,?,?,?)";
	private static final String SEL_CUST = "select * from Customer"; 
	private static final String GET_ID_QUERY="select id from Customer where PAN=?";
	@Override
	public void create(Customer object) {
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(INSERT_CUSTOMER);
			
			ps.setString(1, object.getTitle());
			ps.setString(2, object.getFirstname());
			ps.setString(3, object.getLastname());
			ps.setString(4, object.getAge());
			ps.setString(5, object.getDOB());
			ps.setString(6, object.getPAN());
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static int getIdFromPAN(String PAN)
	{
		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement(GET_ID_QUERY);
			ps.setString(1, PAN);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
				return rs.getInt("id");
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}	
		return -1;
	} 
	

	}

// @Override
// public List<Card> findAll() {
// try (Connection con = ConnectionUtil.getConnection()) {
// PreparedStatement ps = con.prepareStatement(SQL_SELECT);
// ps.setInt(1, id);
// ResultSet rs = ps.executeQuery();
// Card e = new Card();
// while (rs.next()) {
//
//
//
// return cardlist;
// } catch (SQLException ex) {
// ex.printStackTrace();
// return null;
// }
//
//
// }
// }

	
	
	


