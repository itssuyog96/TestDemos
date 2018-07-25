package com.zycus.appdata;

public class CreditCard extends Card {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4622753757655599133L;
	private float interestRate = 0.125f;
	private int creditLimit = 50000;
	private float pointsAccumulated = 10;

	public CreditCard(long cardNo, String holderName, String pAN, String contact, float interestRate, int creditLimit,
			float pointsAccumulated) {
		super(cardNo, holderName, pAN, contact);
		this.interestRate = interestRate;
		this.creditLimit = creditLimit;
		this.pointsAccumulated = pointsAccumulated;
	}

	@Override
	public String toString() {
		return super.toString() + " CreditCard [interestRate=" + interestRate + ", creditLimit=" + creditLimit
				+ ", pointsAccumulated=" + pointsAccumulated + "]";
	}

}
