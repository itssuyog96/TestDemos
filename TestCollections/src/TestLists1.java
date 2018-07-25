import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TestLists1 {

	public static void main(String[] args) {
		List<Person> people = new LinkedList<>();

		people.add(new Person("Gajendra", 50, "gajendra@gmail.com"));
		people.add(new Person("Gajendrax", 35, "g.itsme@gmail.com"));

		ListIterator<Person> it = people.listIterator();
		while (it.hasNext()) {
			System.out.println(it.next().getName());
		}

	}

}
