package com.diksha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentDOA implements CommonDAO<PaymentIn>{
	
	private List<PaymentIn> cardlist = new ArrayList<PaymentIn>();
	
	private static final String INSERT_Pay = "INSERT INTO Payment(Accno,Paybal, Dateofpay, Paytype, ConN, fac_id) values(?, ?, ?, ?, ?, ?)";
	private static final String SEL_ACC="Select Accno,Paybal, Dateofpay, Paytype, ConN from Payment where accno=?";
	@Override
	public void create(PaymentIn object) {
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(INSERT_Pay);
			
			ps.setInt(1, object.getAccno());
			ps.setInt(2, object.getPaybal());
			ps.setString(3, object.getDateofpay());
			ps.setString(4, object.getPaytype());
			ps.setString(5, object.getConN());
			ps.setInt(6, object.getFacId());
			
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static List<PaymentIn> getDataFromAccNo(int accno)
	 {
		 List<PaymentIn> cardlist = new ArrayList<PaymentIn>();
		 try (Connection con = ConnectionUtil.getConnection()) {
				PreparedStatement ps = con.prepareStatement(SEL_ACC);
				
			
				ps.setInt(1, accno);
		        
		         ResultSet rs = ps.executeQuery();
		         while(rs.next()){
		        	 PaymentIn account=new PaymentIn();
		         account.setAccno(rs.getInt("Accno"));
		         account.setPaybal(rs.getInt("Paybal"));
		         account.setDateofpay(rs.getString("Dateofpay"));
		         account.setPaytype(rs.getString("Paytype"));
		         account.setConN(rs.getString("ConN"));
		         
		         cardlist.add(account);
		         }
		         return cardlist;
	 }
		 catch (SQLException ex) {
				ex.printStackTrace();
			}
	
	
	return null;

}
}
