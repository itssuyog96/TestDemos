package com.zycus.appui;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Scanner;

import com.zycus.appdata.Card;
import com.zycus.appdata.CardFactory;
import com.zycus.appdata.CardStore;
import com.zycus.appdata.CardType;

public class Main {
	static Scanner sc = new Scanner(in);

	public static void main(String[] args) {
		out.println("Loading Data File...");
		CardStore.loadCards();
		out.println("Data Loading finished.\n\n\n");
		CardStore.printAllCards();
		menu();
		out.println("\n\nSyncing Data...");
		CardStore.storeCards();
		out.println("Data Sync Complete...\n\nQuitted!");
	}

	private static void menu() {

		String input;
		boolean exit = false;

		do {

			out.println("\n\n---------MENU---------");
			out.println("A. Add New Card");
			out.println("F. Find Card by Card Number");
			out.println("L. List Cards by Holder's Name");
			out.println("Q. Quit Application");
			input = sc.nextLine().toLowerCase();

			switch (input) {
			case "a":
				addNewCard();
				break;
			case "f":
				findCardByNo();
				break;
			case "l":
				findByHolderName();
				break;
			case "q":
				out.print("Are you sure you want to exit? (y/n) :");
				switch (sc.nextLine().toLowerCase()) {
				case "y":
					exit = true;
					break;
				}
				break;
			}

		} while (!exit);

	}

	private static void addNewCard() {
		out.println("Select Card Type-");
		out.println("D. Debit Card");
		out.println("C. Credit Card");
		out.println("B. Back");
		String input = sc.nextLine().toUpperCase();
		switch (input) {
		case "D":
			long cardNo = CardStore.addCard(CardFactory.issueNewCard(CardType.DEBIT));
			out.println("New Card Created!");
			out.println("New Card No.:" + cardNo);
			break;
		case "C":
			cardNo = CardStore.addCard(CardFactory.issueNewCard(CardType.CREDIT));
			out.println("New Card Created!");
			out.println("New Card No.:" + cardNo);
			break;
		case "B":
			break;
		default:
			out.println("Invalid option selected. Try Again!\n\n\n");
		}
	}

	private static void findCardByNo() {
		try {
			out.println("Enter Card No. :");
			long cardNo = sc.nextLong();

			Card card = CardStore.getCardByNo(cardNo);
			if (card != null) {
				out.println("Search successfull!");
				// CardFactory.printCardDetails(card);
				out.println(card);
				out.println("\n\n");
			} else {
				out.println("No records found!!\n\n");
			}
		} catch (Exception e) {
			out.println("Invalid Input!\n\n");
			sc.nextLine();
		}
	}

	private static void findByHolderName() {
		out.println("Enter Holder's Full Name No. :");
		String name = sc.nextLine();

		Card[] cards = CardStore.listCards(name);
		if (cards != null) {
			out.println("Search successfull!");
			for (Card card : cards) {
				if (card == null)
					break;
				CardFactory.printCardDetails(card);
			}
			out.println("\n\n");
		} else {
			out.println("No records found!!\n\n");
		}
	}
}
