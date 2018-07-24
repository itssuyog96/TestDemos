import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet1 {

	public static void main(String[] args) {
		Set<Person> set = new HashSet<>();
		set.add(new Person("Gajendra", 50, "gajendra@gmail.com"));
		set.add(new Person("Gajendrax", 35, "g.itsme@gmail.com"));

		System.out.println(set.size());

		Iterator<Person> it = set.iterator();

		while (it.hasNext()) {
			System.out.println(it.next().getName());
		}

	}

}
