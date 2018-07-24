package com.zycus.appdata;

public class DebitCard extends Card {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7048009025541487809L;
	private static final int MAX_WITHDRAWAL = 10000;
	private long accountLinked;

	public DebitCard(long cardNo, String holderName, String pAN, String contact, long accountLinked) {
		super(cardNo, holderName, pAN, contact);
		this.accountLinked = accountLinked;
	}

	public long getAccountLinked() {
		return accountLinked;
	}

	public void setAccountLinked(long accountLinked) {
		this.accountLinked = accountLinked;
	}

	@Override
	public String toString() {
		return super.toString() + " DebitCard [accountLinked=" + accountLinked + "]";
	}

}
