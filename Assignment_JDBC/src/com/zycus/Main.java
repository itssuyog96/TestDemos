package com.zycus;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {

	private static final String SQL_CREATE_CUTOMER_TABLE = "CREATE TABLE CUSTOMER(" + "ID NUMERIC(11) PRIMARY KEY,"
			+ "FIRSTNAME VARCHAR(20)," + "LASTNAME VARCHAR(20)," + "EMAIL VARCHAR(20)" + ")";
	private static final String SQL_CREATE_CARD_TABLE = "CREATE TABLE CARD(ID NUMERIC(11) PRIMARY KEY," + "EXPIRY DATE,"
			+ "CUSTOMERID NUMERIC(11)," + "BALANCE NUMERIC(7, 2)," + "CREDITLIMIT NUMERIC(5),"
			+ "  FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMER(ID) )";

	public static void main(String[] args) {
		Connection con = ConnectionUtil.getConnection();
		try {
			Statement st = con.createStatement();
			// st.executeUpdate(SQL_CREATE_CUTOMER_TABLE);
			st.executeUpdate(SQL_CREATE_CARD_TABLE);
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Perform Operations on Tables

		// Insert Operations
		CustomerDAO customer = new CustomerDAO();
		CardDao card = new CardDao();

		// customer.create(new Customer(1011l, "Tony", "Stark",
		// "tony.stark@gmail.com"));
		// customer.create(new Customer(1012l, "Meghan", "Fox",
		// "meghan.fox@gmail.com"));

		card.create(new Card(901l, Date.valueOf("2020-04-27"), 1012l, 2300.25f, 10000));

		List<Customer> customerList = customer.findAll();
		for (Customer c : customerList) {
			System.out.println(c);
		}

		List<Card> cardList = card.findAll();
		for (Card c : cardList) {
			System.out.println(c);
		}

	}
}
