package com.zycus;

public class Person {

	private String firstName, lastName;
	private Address address;

	public Person(String firstName, String lastName, String line1, String line2, String city, String state) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = new Address(line1, line2, city, state);
	}

	private class Address {
		private String line1, line2, city, state;

		public Address(String line1, String line2, String city, String state) {
			this.line1 = line1;
			this.line2 = line2;
			this.city = city;
			this.state = state;
		}

		@Override
		public String toString() {
			String sep = ", ";
			return " Address[" + line1 + sep + line2 + sep + city + sep + state + "]";
		}
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + "]";
	}

}
