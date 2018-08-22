package com.zycus.banking.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zycus.banking.customer.Customer;
import com.zycus.banking.util.ConnectionUtil;

public class AccountDAO {

	private static final String SQL_INSERT = "INSERT INTO ACCOUNT(ACCOUNTNO, BRANCHCODE, ACCOUNTTYPE, BALANCE, CUST_ID, BANKCODE) VALUES(?, ?, ?, ?, ?, ?)";
	private static final String SQL_GET_BY_CUSTOMER = "SELECT ACCOUNTNO, BANKCODE, BRANCHCODE, ACCOUNTTYPE, BALANCE FROM ACCOUNT WHERE CUST_ID=?";
	// private static final String SQL_SELECT_ID = "SELECT BRANCHCODE, BANKCODE FROM
	// BRANCH";
	// private static final String SQL_SELECT_BANK = "SELECT BRANCHCODE, BANKCODE
	// FROM BRANCH WHERE BANKCODE=?";

	public void create(Account account) {
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT);) {

			ps.setLong(1, account.getAccountNumber());
			ps.setInt(2, account.getBranchCode());
			ps.setInt(3, account.getAccountType().ordinal());
			ps.setFloat(4, account.getBalance());
			ps.setString(5, account.getAccountHolder().getId());
			ps.setString(6, account.getBankCode());
			ps.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	//
	// public List<Branch> findAll() {
	// List<Branch> branches = new LinkedList<>();
	// try (Connection con = ConnectionUtil.getConnection()) {
	// PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID);
	//
	// ResultSet rs = ps.executeQuery();
	//
	// while (rs.next()) {
	// branches.add(new BranchMap(rs.getString(2), rs.getInt(1)));
	// }
	//
	// return branches;
	//
	// } catch (SQLException ex) {
	// ex.printStackTrace();
	// return null;
	// }
	//
	// }
	//
	// public List<Branch> findAllByBank(String bankCode) {
	// List<Branch> branches = new LinkedList<>();
	// try (Connection con = ConnectionUtil.getConnection()) {
	// PreparedStatement ps = con.prepareStatement(SQL_SELECT_BANK);
	//
	// ps.setString(1, bankCode);
	// ResultSet rs = ps.executeQuery();
	//
	// while (rs.next()) {
	// branches.add(new BranchMap(rs.getString(2), rs.getInt(1)));
	// }
	//
	// return branches;
	//
	// } catch (SQLException ex) {
	// ex.printStackTrace();
	// return null;
	// }
	//
	// }
	//
	public List<Account> findByCustomer(Customer customer) {

		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(SQL_GET_BY_CUSTOMER);
			ps.setString(1, customer.getId());
			ResultSet rs = ps.executeQuery();
			List<Account> accounts = new ArrayList<>();

			while (rs.next()) {
				accounts.add(new Account(rs.getLong(1), customer, accountType.values()[rs.getInt(4)], rs.getFloat(5),
						rs.getString(2), rs.getInt(3)));
			}

			return accounts;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

}