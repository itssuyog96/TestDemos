package demo1;
import java.util.Date;

/**
 * LoanAccount represents all kinds of loan accounts.
 * @author suyog.gadhave
 *
 */
public class LoanAccount extends Account {
	
	/**
	 * The total amount of loan.
	 * This is DUE by customer.
	 */
	private float totalOutstanding;

	/**
	 * Initializes LoanAccount object.
	 * @param accountNo			Unique account number
	 * @param customerId		Unique customer id
	 * @param branchCode		Branch where the account is maintained
	 * @param openingDate		Date of opening account
	 * @param totalOutstanding	Total amount that is due by customer
	 */
	public LoanAccount(int accountNo, int customerId, int branchCode, Date openingDate, float totalOutstanding) {
		super(accountNo, customerId, branchCode, openingDate);
		this.totalOutstanding = totalOutstanding;
	}

	/**
	 * String representation of LoanAccount object.
	 */
	@Override
	public String toString() {
		return super.toString() + " LoanAccount [totalOutstanding=" + totalOutstanding + "]";
	}
	

}
