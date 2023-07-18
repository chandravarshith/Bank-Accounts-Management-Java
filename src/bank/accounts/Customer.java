package bank.accounts;

public class Customer {
	private String customerName;
	private int accountNumber;
	private String accountType;
	private double accountBalance; 
	
	public Customer(String customerName, int accountNumber, String accountType) {
		super();
		this.customerName = customerName;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountBalance = 100000.0;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	
}
