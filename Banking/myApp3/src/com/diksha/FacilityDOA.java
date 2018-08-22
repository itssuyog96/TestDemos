package com.diksha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityDOA implements CommonDAO<FacilityIn> {
	
	private List<FacilityIn> cardlist = new ArrayList<FacilityIn>();
	private static final String SQL_SELECT_ID_CUSTOMER = "select * from Account where id = ?";
	private static final String INSERT_CUSTOMER = "INSERT INTO facility(accno,paytype,Provider,ConsumerNo) values(?,?,?,?)";
	private static final String SEL_CUST = "select * from facility";
	private static final String SEL_ACC="select * from facility where accno=?";
	private static final String SEL_ACCC="select ConsumerNo from facility where accno=?";
	private static final String SEL_ACCB="select paytype from facility where accno=?";
	

	@Override
	public void create(FacilityIn object) {
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(INSERT_CUSTOMER);
			
			System.out.println(object);
			ps.setInt(1, object.getAccno());
			//ps.setInt(2, object.getPaybal());
			//ps.setString(3, object.getDateofpay());
			ps.setString(2, object.getPaytype());
			ps.setString(3, object.getProvider());
			ps.setString(4, object.getConN());
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	 public static List<FacilityIn> getDataFromAccNo(int accno)
	 {
		 List<FacilityIn> cardlist = new ArrayList<FacilityIn>();
		 try (Connection con = ConnectionUtil.getConnection()) {
				PreparedStatement ps = con.prepareStatement(SEL_ACC);
				
			
				ps.setInt(1, accno);
		        
		         ResultSet rs = ps.executeQuery();
		         while(rs.next()){
		        	 FacilityIn account=new FacilityIn();
		        	 account.setId(rs.getInt("id"));
		         account.setAccno(rs.getInt("accno"));
		         account.setPaytype(rs.getString("paytype"));
		         account.setProvider(rs.getString("Provider"));
		         account.setConN(rs.getString("ConsumerNo"));
		         
		         cardlist.add(account);
		         }
		         return cardlist;
	 }
		 catch (SQLException ex) {
				ex.printStackTrace();
			}
	
	
	return null;

}
	 public static String getConsumeFromID(int accno)
	 {
		 
		 try (Connection con = ConnectionUtil.getConnection()) {
			 PreparedStatement ps = con.prepareStatement(SEL_ACCC);
				ps.setInt(1, accno);
				ResultSet rs = ps.executeQuery();
				if (rs.next())
				{
					return rs.getString("ConsumerNo");
				}
		 }
		 catch (SQLException ex) {
				ex.printStackTrace();
			}
	
	
	return null;

}
	 public static String getProviderFromID(int accno)
	 {
		 
		 try (Connection con = ConnectionUtil.getConnection()) {
			 PreparedStatement ps = con.prepareStatement(SEL_ACCB);
				ps.setInt(1, accno);
				ResultSet rs = ps.executeQuery();
				if (rs.next())
				{
					return rs.getString("paytype");
				}
		 }
		 catch (SQLException ex) {
				ex.printStackTrace();
			}
	
	
	return null;
	
	

}
}
