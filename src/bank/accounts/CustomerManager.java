package bank.accounts;

import java.util.ArrayList;

public class CustomerManager {
	private int index;
	private ArrayList<Customer> customers;
	
	public CustomerManager() {
		this.setIndex(0);
		this.customers = new ArrayList<Customer>();
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public Customer getCustomer(int accNum) {
		int i = 0;
		while(i < this.customers.size()) {
			Customer c = this.customers.get(i);
			if(c.getAccountNumber() == accNum) {
				this.index = i;
				return c;
			}
			i++;
		}
		return null;
	}

	public void addCustomer(Customer c) {
		this.customers.add(c);
		System.out.println("\nCustomer added successfully!\n");
	}

	public Customer updateCustomer(int accNum, String newValue, int updateOption) {
		Customer c = getCustomer(accNum);
		if(updateOption == 1) {
			c.setCustomerName(newValue);
		}
		else if(updateOption == 2) {
			c.setAccountType(newValue);
		}
		this.customers.set(this.index, c);
		System.out.println("\nCustomer updated successfully!\n");
		return null;
	}

	public boolean displayCustomer(int accNum) {
		Customer c = getCustomer(accNum);
		if(c == null) {
			System.out.println("\nSorry the customer doesn't exist!\n");
			return false;
		}
		System.out.println("____________________________________Customer Details_________________________________________\n");
		System.out.println("\t\t\tCustomer Name\t\t:\t"+c.getCustomerName());
		System.out.println("\t\t\tAccount Number\t\t:\t"+c.getAccountNumber());
		System.out.println("\t\t\tAccount Type\t\t:\t"+c.getAccountType());
		System.out.println("\t\t\tAccount Balance\t\t:\t$"+c.getAccountBalance());
		System.out.println("_____________________________________________________________________________________________\n");
		return true;
	}

	public void deleteCustomer(int accNum) {
		Customer c = getCustomer(accNum);
		this.customers.remove(this.index);
		System.out.println("\nCustomer deleted successfully!\n");
	}

	public void depositMoney(int accNum, Double depositMoney) {
		Customer c = getCustomer(accNum);
		c.setAccountBalance(c.getAccountBalance()+depositMoney);
		this.customers.set(this.index, c);
		System.out.println("\nAmount deposited successfully!");
		System.out.println("Current account balance = $"+c.getAccountBalance());
		System.out.println();
	}

	public void withdrawMoney(int accNum, Double amount) {
		Customer c = getCustomer(accNum);
		if(c.getAccountBalance() < amount) {
			System.out.println("\nAmount cannot be withdrawn as your current balance is $"+c.getAccountBalance());
			System.out.println();
		}
		else {
			c.setAccountBalance(c.getAccountBalance()-amount);
			this.customers.set(this.index, c);
			System.out.println("\nAmount withdrawn successfully!");
			System.out.println("Current account balance = $"+c.getAccountBalance());
			System.out.println();
		}
	}
	
	public boolean checkAccountType(int accNum) {
		Customer c = getCustomer(accNum);
		if(c.getAccountType().equals("Savings")) {
			System.out.println("\nMoney cannot be withdrawn from Savings Account!\n");
			return false;
		}
		return true;
	}

	public void displayCustomersList() {
		int i = 0;
		System.out.println("__________________________________________Customers List__________________________________________________\n");
		System.out.printf("\t%10s %23s %22s %22s\n","Account Number","Customer Name","Account Type","Account Balance");
		System.out.println("__________________________________________________________________________________________________________\n");
		while(i < this.customers.size()) {
			Customer c = this.customers.get(i);
			System.out.format("\t%10s %27s %19s %21s", c.getAccountNumber(), c.getCustomerName(), 
					c.getAccountType(),c.getAccountBalance());  
			System.out.println();  
			i++;
		}
		System.out.println("__________________________________________________________________________________________________________\n");
	}
	
	
}
