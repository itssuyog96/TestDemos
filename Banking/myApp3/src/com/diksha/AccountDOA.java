package com.diksha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDOA implements CommonDAO<Account> {
	
	private List<Account> cardlist = new ArrayList<Account>();
	private static final String SQL_SELECT_ID_CUSTOMER = "select * from Account where id = ?";
	private static final String INSERT_CUSTOMER = "INSERT INTO Account(pass,balance,acct,Customerid) values(?, ?, ?,?)";
	private static final String SEL_ACC="select balance,ACCT from Account where id=?";
	private static final String GET_ID_QUERY="select id from Account where Customerid=?";
	private static final String Bal_Change="UPDATE Account SET Balance=? where id=?";
	private static final String Get_Bal="select balance from Account where id=?";
	//private static final String GET_ACC_NO_FROM_ID = "select id from account where customer"
	
	
	
	@Override
	public void create(Account object) {
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(INSERT_CUSTOMER);
			
			
			ps.setInt(1, object.getPass());
			ps.setFloat(2, object.getBalance());
			ps.setString(3, object.getAcct());
			ps.setInt(4, object.getCustomerid());
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	public static List<Account> getDataFromAccNo(int accno)
	 {
		 List<Account> cardlist = new ArrayList<Account>();
		 try (Connection con = ConnectionUtil.getConnection()) {
				PreparedStatement ps = con.prepareStatement(SEL_ACC);
				
			
				ps.setInt(1, accno);
		        
		         ResultSet rs = ps.executeQuery();
		         while(rs.next()){
		         Account account=new Account();
		         account.setAcct(rs.getString("ACCT"));
		         account.setBalance(rs.getInt("balance"));
		         
		         
		         cardlist.add(account);
		         }
		         return cardlist;
	 }
		 catch (SQLException ex) {
				ex.printStackTrace();
			}
	
	
	return null;

}
	public static int getIdFromCustID(int id)
	{
		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement(GET_ID_QUERY);
			ps.setInt(1, id);
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
	
	public static int GetBal(int a)
	{
		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement(Get_Bal);
			ps.setInt(1, a);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
				
				return rs.getInt("balance");
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}	
		return -1;
	}
	
	
	public static boolean ChangeBal(int a,int temp)
	{
		try(Connection con = ConnectionUtil.getConnection()){
			PreparedStatement ps = con.prepareStatement(Bal_Change);
			ps.setInt(2, a);
			//ResultSet rs = ps.executeQuery();
			
				
				ps.setFloat(1,temp);
				ps.executeUpdate();
				return true;
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			return false;
		}	
		
	}
	}

	


