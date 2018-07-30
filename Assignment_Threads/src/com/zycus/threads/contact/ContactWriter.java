package com.zycus.threads.contact;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ContactWriter implements Runnable {

	private static List<Contact> contactList = new LinkedList<>();
	private BufferedWriter out;

	public ContactWriter(String path) {
		super();
		try {
			out = new BufferedWriter(new FileWriter(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	static void addContactList(Contact contact) {
		ContactWriter.contactList.add(contact);
	}

	@Override
	public void run() {
		try {
			for (Contact contact : contactList) {
				out.write(contact.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
