package com.diksha;

public class FacilityIn {
	
	
	private int id;
	private int accno;
	private String ConN;
	//private int paybal; 
	//private String Date of pay; 
	private String paytype; 
	private String Provider;
	public FacilityIn() {
		super();
	}
	
	public FacilityIn(int accno,String paytype,String ConN,String provider) {
		super();
		this.accno = accno;
		this.ConN = ConN;
		//this.paybal = paybal;
		//Date of pay = date of pay;
		this.paytype = paytype;
		Provider = provider;
	}
	
	
	public String getConN() {
		return ConN;
	}


	public void setConN(String conN) {
		ConN = conN;
	}


	//private String Provider;
	
	
	


	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
//	public int getPaybal() {
//		return paybal;
//	}
//	public void setPaybal(int paybal) {
//		this.paybal = paybal;
//	}
//	public String getDateofpay() {
//		return Dateofpay;
//	}
//	public void setDateofpay(String dateofpay) {
//		Dateofpay = dateofpay;
//	}
	public String getPaytype() {
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	public String getProvider() {
		return Provider;
	}
	public void setProvider(String provider) {
		Provider = provider;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "FacilityIn [accno=" + accno + ", ConN=" + ConN + ", paytype=" + paytype + ", Provider=" + Provider
				+ "]";
	}



	
	
	

}
