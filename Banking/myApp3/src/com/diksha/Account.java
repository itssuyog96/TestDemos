package com.diksha;

public class Account {
	
	
	private int balance;
	private String acct;
	private int pass;
	private int Customerid;
	
	

 public Account() {
		super();
	}

public Account(int balance, String acct, int Customerid,int pass) {
		super();
		
		this.Customerid=Customerid;
		this.balance = balance;
		this.pass= pass;
		this.acct = acct;
	}

public int getPass() {
	return pass;
}

public void setPass(int pass) {
	this.pass = pass;
}



public int getCustomerid() {
	return Customerid;
}

public void setCustomerid(int customerid) {
	Customerid = customerid;
}

public String getAcct() {
		return acct;
	}


public void setAcct(String acct) {
		this.acct = acct;
	}

public void setBalance(int balance) {
		this.balance = balance;
	}


public int getBalance()
{
	return balance;
}

}
