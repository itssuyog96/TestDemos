package com.zycus.banking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;



public class CustomerDAO{
	
	private static final String SQL_SELECT_ID="SELECT id, firstName, lastName, dob, title FROM customer";
	private static final String SQL_INSERT="INSERT INTO CUSTOMER(id, firstName, lastName, dob, title) VALUES(?,?,?,?,?)";

	public void create(Customer customer) {
		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement(SQL_INSERT);
			ps.setString(1, customer.getId());
			ps.setString(2, customer.getFirstName());
			ps.setString(3, customer.getLastName());
			ps.setDate(4, customer.getDob());
			ps.setString(5,  customer.getTitle());
			ps.executeUpdate();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	public List<Customer> findAll() {
		List<Customer> customers = new LinkedList<>();
		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Customer customer = new Customer(rs.getString(1), rs.getString(2), rs.getString(4), rs.getString(6), rs.getDate(5));
				customers.add(customer);
			}
			
			return customers;
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
		
		
	}

	public Customer findById(int id) {
		
		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement("select id, firstName, lastName, dob, title from customer where id = ? ");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			Customer customer = null;
			
			if(rs.next()) {
				customer = new Customer(rs.getString(1), rs.getString(2), rs.getString(4), rs.getString(6), rs.getDate(5));
			}
			
			return customer;
		}catch(SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}


}