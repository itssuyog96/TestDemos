package com.zycus.appdata;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

public class CardStore {

	private static final String DATA_PATH = "D:\\data\\CardData.dat";
	private static Card[] cardList = new Card[100];
	private static int cardsCounter = 0;

	public static void printAllCards() {
		for (Card card : cardList) {
			if (card == null)
				break;
			System.out.println(card);
		}
	}

	public static void storeCards() {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_PATH))) {
			for (Card card : cardList) {
				if (card == null)
					break;
				out.writeObject(card);
				out.flush();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void loadCards() {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATA_PATH))) {
			cardsCounter = 0;
			while (true) {
				Object obj = in.readObject();

				if (obj instanceof DebitCard) {
					cardList[cardsCounter++] = (DebitCard) obj;
				}

				if (obj instanceof CreditCard) {
					cardList[cardsCounter++] = (CreditCard) obj;
				}
			}
		} catch (StreamCorruptedException e) {
			System.out.println("Data file is corrupted. Can't load previous items.");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("File not intialized yet.");
		}
	}

	public static long addCard(Card card) {
		cardList[cardsCounter++] = card;
		return card.getCardNo();
	}

	public static Card getCardByNo(long cardNo) {
		for (Card card : cardList) {
			if (card == null)
				break;

			if (card.getCardNo() == cardNo) {
				return card;
			}
		}

		return null;
	}

	public static Card[] listCards(String name) {
		Card[] foundCards = new Card[5];
		int i = 0;

		for (Card card : cardList) {
			if (card == null)
				break;

			if (card.getHolderName().toLowerCase().equals(name.toLowerCase())) {
				foundCards[i++] = card;
			}
		}

		return i > 0 ? foundCards : null;
	}

}
