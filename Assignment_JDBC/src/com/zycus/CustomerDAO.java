package com.zycus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CustomerDAO implements CommonDao<Customer> {

	private static final String SQL_CREATE = "INSERT INTO CUSTOMER(ID, FIRSTNAME, LASTNAME, EMAIL) VALUES(?, ? , ? , ?)";
	private static final String SQL_FIND_ALL = "SELECT * FROM CUSTOMER";
	private static final String SQL_FIND_BY_ID = "SELECT * FROM CUSTOMER WHERE ID=?";

	@Override
	public void create(Customer object) {
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(SQL_CREATE);
			ps.setLong(1, object.getId());
			ps.setString(2, object.getFirstName());
			ps.setString(3, object.getLastName());
			ps.setString(4, object.getEmail());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Customer> findAll() {
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(SQL_FIND_ALL);
			ResultSet rs = ps.executeQuery();
			List<Customer> list = new LinkedList<>();

			while (rs.next()) {
				list.add(convert(rs));
			}

			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Customer findById(long value) {
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(SQL_FIND_BY_ID);
			ps.setLong(0, value);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return convert(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return null;
	}

	private static Customer convert(ResultSet rs) throws SQLException {
		return new Customer(rs.getLong("ID"), rs.getString("FIRSTNAME"), rs.getString("LASTNAME"),
				rs.getString("EMAIL"));
	}

}
