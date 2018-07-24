package com.zycus.appdata;

import java.io.Serializable;

public abstract class Card implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1393900319701431502L;
	private long cardNo;
	private String holderName;
	private String PAN;
	private String contact;

	public Card(long cardNo, String holderName, String pAN, String contact) {
		super();
		this.cardNo = cardNo;
		this.holderName = holderName;
		PAN = pAN;
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Cards [cardNo=" + cardNo + ", holderName=" + holderName + ", PAN=" + PAN + ", contact=" + contact + "]";
	}

	public long getCardNo() {
		return cardNo;
	}

	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getPAN() {
		return PAN;
	}

	public void setPAN(String pAN) {
		PAN = pAN;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
}
