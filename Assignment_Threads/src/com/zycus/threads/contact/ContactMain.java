package com.zycus.threads.contact;

public class ContactMain {
	public static void main(String[] args) {
		ContactWriter.addContactList(new Contact("Isaac", "Newton", 50, 7895242314l, "isaacn@gmail.com"));
		ContactWriter.addContactList(new Contact("Thomas", "Edison", 34, 9346872364l, "thomas@gmail.com"));
		ContactWriter.addContactList(new Contact("Mark", "Zuckerberg", 76, 8293947892l, "mark.z@gmail.com"));
		ContactWriter.addContactList(new Contact("Suresh", "Gupta", 21, 7892374927l, "suresh.gupta@gmail.com"));
		ContactWriter.addContactList(new Contact("Dead", "Pool", 89, 7374762837l, "pool.dead@gmail.com"));
		ContactWriter.addContactList(new Contact("Tony", "Stark", 32, 9234782343l, "stark@gmail.com"));
		ContactWriter.addContactList(new Contact("Omkar", "Dubas", 67, 9680237834l, "omkar.flash@gmail.com"));
		ContactWriter.addContactList(new Contact("Neel", "Sharma", 43, 8923648276l, "neel.sharma@gmail.com"));
		ContactWriter.addContactList(new Contact("Mahendra", "Shinde", 32, 9527496326l, "m.shinde@gmail.com"));
		ContactWriter.addContactList(new Contact("Michael", "Jordan", 39, 9021900213l, "m.jordan@gmail.com"));

		new Thread(new ContactWriter("1.csv")).start();
		new Thread(new ContactWriter("2.csv")).start();
		new Thread(new ContactWriter("3.csv")).start();
	}
}
