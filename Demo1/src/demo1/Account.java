package demo1;
import java.util.Date;

/**
 * Account is the base class for all types of accounts such
 * as deposit account, loan account, etc. 
 * @author suyog.gadhave
 *
 */
public abstract class Account {
	/**
	 * The unique account number assigned to each account.
	 */
	private int accountNo;
	/**
	 * The unique customer id assigned to each customer.
	 */
	private int customerId;
	/**
	 * The code of the branch where account is managed.
	 */
	private int branchCode;
	/**
	 * The opening date of the account.
	 */
	private Date openingDate;
	
	/**
	 * Initializes the account object.
	 * @param accountNo		Unique account number to be assigned
	 * @param customerId	Unique customer ID to be assigned
	 * @param branchCode	The branch identifier where account resides
	 * @param openingDate	Date when the account was opened
	 */
	public Account(int accountNo, int customerId, int branchCode, Date openingDate) {
		super();
		this.accountNo = accountNo;
		this.customerId = customerId;
		this.branchCode = branchCode;
		this.openingDate = openingDate;
	}
	
	/**
	 * String representation of account object.
	 */
	@Override
	public String toString(){
		return "Account [accountNo="+ accountNo + ", branchCode=" + branchCode + "]";
	}
	
	
}
