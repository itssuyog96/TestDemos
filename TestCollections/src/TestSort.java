import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TestSort {
	public static void main(String[] args) {
		List<Person> people = new LinkedList<>();

		people.add(new Person("Gajendra", 50, "gajendra@gmail.com"));
		people.add(new Person("Virendra", 35, "v.itsme@gmail.com"));
		people.add(new Person("Mahendra", 40, "m.itsme@gmail.com"));

		ListIterator<Person> it = people.listIterator();
		while (it.hasNext()) {
			System.out.println(it.next().getName());
		}

		Collections.sort(people);
		System.out.println("\n----Sorted----");
		for (Person p : people) {
			System.out.println(p.getName());
		}

		// Collections.sort(people, new Comparator<Person>() {
		//
		// @Override
		// public int compare(Person arg0, Person arg1) {
		// return arg0.getAge() - arg1.getAge();
		// }
		//
		// });

		Comparator<Person> comparator = (p1, p2) -> p1.getAge() - p2.getAge();

		Collections.sort(people, comparator);

		System.out.println("\n----Age-Sorted----");
		for (Person p : people) {
			System.out.println(p.getName() + " " + p.getAge());
		}

		Comparator<Person> compareEmails = (x, y) -> x.getEmail().compareTo(y.getEmail());

		Collections.sort(people, compareEmails);

		System.out.println("\n----Email-Sorted----");
		for (Person p : people) {
			System.out.println(p.getName() + " " + p.getEmail());
		}
	}
}
