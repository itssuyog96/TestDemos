package com.zycus;

import static java.lang.System.out;

public class Main {

	public static void main(String[] args) {
		Employee.Address address = new Employee.Address("Mannat", "Juhu", "Mumbai", "Maharashtra");
		Employee e = new Employee("Shah Rukh", "Khan", address);

		out.println(e);

		Person p = new Person("Amitabh", "Bachan", "Pratiksha", "Bandra", "Mumbai", "Maharashtra");
		out.println(p);

	}

}
