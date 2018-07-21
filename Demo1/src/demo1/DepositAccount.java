package demo1;
import java.util.Date;

/**
 * DepositAccount represents all kind of Deposits, including Fixed or recurring.
 * @author suyog.gadhave
 *
 */
public class DepositAccount extends Account{
	
	/**
	 * The total amount deposited so far.
	 * Also this is DUE from bank.
	 */
	private float totalDeposit;

	/**
	 * Initializes a new DepositAccount
	 * @param accountNo		Unique account number
	 * @param customerId	Unique customer id
	 * @param branchCode	Branch where account is maintained
	 * @param openingDate	Date of opening account
	 * @param totalDeposit	Current balance
	 */
	public DepositAccount(int accountNo, int customerId, int branchCode, Date openingDate, float totalDeposit) {
		super(accountNo, customerId, branchCode, openingDate);
		this.totalDeposit = totalDeposit;
	}

	
	/**
	 * String representation of DepositAccount object.
	 */
	@Override
	public String toString() {
		return super.toString() + " DepositAccount [totalDeposit=" + totalDeposit + "]";
	}
	
	
}
