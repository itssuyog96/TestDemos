package demo1;
import java.util.Date;

public class App2 {

	public static void main(String[] args) {

		Account account = new DepositAccount(12312, 123123, 213123, new Date(), 20000.50f);
		
		Account acc2 = new LoanAccount(12312, 123123, 213123, new Date(), 1500.0f);
		
		Customer customer = new Customer(23423, "Charlie");
		customer.addAccount(account);
		customer.addAccount(acc2);
		customer.printSummary();
		
	}

}
