package com.zycus.appdata;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Scanner;

public class CardFactory {
	public static Card issueNewCard(CardType CARD_TYPE) {

		String name, pan, contact;
		Scanner sc = new Scanner(in);
		out.println("Enter following details for new card issue-");

		out.print("Holder Name :");
		name = sc.nextLine();
		out.print("PAN No. :");
		pan = sc.nextLine();
		out.print("Contact :");
		contact = sc.nextLine();

		switch (CARD_TYPE) {
		case DEBIT:
			out.print("Account Linked :");
			long accountLinked = sc.nextLong();

			return new DebitCard(generateCardNo(), name, pan, contact, accountLinked);

		case CREDIT:
			out.print("Interest Rate :");
			float interestRate = sc.nextFloat();
			out.print("Credit Limit :");
			int creditLimit = sc.nextInt();
			out.print("Points Accumulated :");
			float pointsAccumulated = sc.nextFloat();

			return new CreditCard(generateCardNo(), name, pan, contact, interestRate, creditLimit, pointsAccumulated);
		}

		return null;

	}

	public static void printCardDetails(Card card) {
		System.out.println(card instanceof DebitCard ? (DebitCard) card : (CreditCard) card);
	}

	private static long generateCardNo() {
		return currentTimeMillis() % 9999999999999999l;
	}
}
