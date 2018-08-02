package com.zycus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CardDao implements CommonDao<Card> {

	private static final String SQL_CREATE = "INSERT INTO CARD(ID, EXPIRY, CUSTOMERID, BALANCE, CREDITLIMIT) VALUES(?, ? , ? , ?, ?)";
	private static final String SQL_FIND_ALL = "SELECT * FROM CARD";
	private static final String SQL_FIND_BY_ID = "SELECT * FROM CARD WHERE ID=?";

	@Override
	public void create(Card object) {
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(SQL_CREATE);
			ps.setLong(1, object.getId());
			ps.setDate(2, object.getExpiry());
			ps.setLong(3, object.getCustomerId());
			ps.setFloat(4, object.getBalance());
			ps.setInt(5, object.getCreditLimit());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Card> findAll() {
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(SQL_FIND_ALL);
			ResultSet rs = ps.executeQuery();
			List<Card> list = new LinkedList<>();

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
	public Card findById(long value) {
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

	private static Card convert(ResultSet rs) throws SQLException {
		return new Card(rs.getLong("ID"), rs.getDate("EXPIRY"), rs.getLong("CUSTOMERID"), rs.getFloat("BALANCE"),
				rs.getInt("CREDITLIMIT"));
	}

}
