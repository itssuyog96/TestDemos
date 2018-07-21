package demo1;

public class App1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long memoryMax = Runtime.getRuntime().maxMemory();
		long memoryTotal = Runtime.getRuntime().totalMemory();

		System.out.println("Max Memory: " + memoryMax / 1000 / 1000);
		System.out.println("Max Memory: " + memoryTotal / 1000 / 1000);

		Employeex e = new Employeex();
		e.print();

		e.setLastName("Cooper");
		e.print();

		UDate date1 = new UDate(29, 2, 2016);
		UDate.setDateStyle(UDate.NORMAL_DATE);
		System.out.println(date1.toString());

		UDate date2 = new UDate(34, 2, 2018);

		System.out.println("Are they equal? " + date1.equals(date2));
		System.out.println("HashCodes: " + date1.hashCode() + ", " + date2.hashCode());

	}

}
