package bank.accounts;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankAccountsManager {
	
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		CustomerManager cm = new CustomerManager();
		Customer c = null;
		
		System.out.println("Welcome to Bank Accounts Management\n");
		
		//program loop
		boolean exit = false;
		while(!exit) {
			
			//validating option
			int op = 0;
			while(true) {
				System.out.println("---------Menu------------");
				System.out.println("1. Add Customer\n"
								+ "2. Update Customer\n"
								+ "3. Delete Customer\n"
								+ "4. Deposit Money\n"
								+ "5. Withdraw Money\n"
								+ "6. Display Customer List\n"
								+ "7. Exit");
				System.out.println("-------------------------");
				System.out.print("Choose the option: ");
				try {
					op = sc.nextInt();
					System.out.println();
				}
				catch (InputMismatchException e) {
					op = 0;
			    }
				finally {
					sc.nextLine();
					if(op < 1 || op > 7) {
						System.out.println("Please choose a valid option in the range 1 to 7\n");
					}
					else break;
				}
			}
			
			
			//switch case for the Menu
			switch (op) {
			
				//1. Add Customer
				case 1:
					System.out.println("Please, provide the customer details:");
					
					//Account Number Input validation
					int accNum = -1;
					while(true){
						try {
							System.out.print("Account Number: ");
							accNum = sc.nextInt();
						}
						catch (InputMismatchException e) {
							accNum = -1;
					    }
						finally {
							sc.nextLine();
							if(accNum < 0 || accNum > 9999999) {
								System.out.println("Please enter a valid Account Number!\n");
							}
							else break;
						}
					}
					
					if(cm.getCustomer(accNum) != null) {
						System.out.println("\nCustomer already exists!\n");
						cm.displayCustomer(accNum);
						break;
					}
					
					//Customer Name Input validation
					String custName = "";
					while(true) {
						System.out.print("Customer Name: ");
						custName = sc.nextLine();
						if(custName.matches("^[a-zA-Z ]*$")) {
							break;
						}
						else {
							System.out.println("Please enter a valid name!\n");
						}
					}
					
					//Account Type Input validation
					String accountType = "";
					int accTypeOption = 0;
					while(true) {
						System.out.println("\n--Account types--");
						System.out.println("1. Checking\n"
										+ "2. Savings");
						System.out.println("-----------------");
						System.out.print("Choose an Account type: ");
						try {
							accTypeOption = sc.nextInt();
							System.out.println();
						}
						catch (InputMismatchException e) {
							accTypeOption = 0;
					    }
						finally {
							sc.nextLine();
							if(accTypeOption < 1 || accTypeOption > 2) {
								System.out.println("Please choose a valid option!\n");
							}
							else {
								if(accTypeOption == 1)
									accountType = "Checking";
								else if(accTypeOption == 2)
									accountType = "Savings";
								break;
							}
						}
					}
					
					c = new Customer(custName,accNum,accountType);
					cm.addCustomer(c);
					
					break;
					
					
				//2. Update Customer
				case 2:
					//Account Number Input validation
					int accNum1 = -1;
					while(true){
						try {
							System.out.print("Account Number: ");
							accNum1 = sc.nextInt();
						}
						catch (InputMismatchException e) {
							accNum1 = -1;
					    }
						finally {
							sc.nextLine();
							if(accNum1 < 0 || accNum1 > 9999999) {
								System.out.println("Please enter a valid Account Number!\n");
							}
							else break;
						}
					}
					
					if(!cm.displayCustomer(accNum1)) break;
					
					//Validating update option
					int updateOption = 0;
					while(true) {
						System.out.println("\n-----Update Menu--------");
						System.out.println("1. Update Customer name\n"
										+ "2. Update Account Type");
						System.out.println("------------------------");
						System.out.print("Choose an Update option: ");
						try {
							updateOption = sc.nextInt();
							System.out.println();
						}
						catch (InputMismatchException e) {
							updateOption = 0;
					    }
						finally {
							sc.nextLine();
							if(updateOption < 1 || updateOption > 2) {
								System.out.println("Please choose a valid option!\n");
							}
							else break;
						}
					}
					
					if(updateOption == 1) {
					//Customer Name Input validation
						String custName1 = "";
						while(true) {
							System.out.print("Enter new Customer Name: ");
							custName1 = sc.nextLine();
							if(custName1.matches("^[a-zA-Z ]*$")) {
								c = cm.updateCustomer(accNum1,custName1,updateOption) ;
								break;
							}
							else {
								System.out.println("Please enter a valid name!\n");
							}
						}
					}
					else if(updateOption == 2) {
					//Account Type Input validation
						String accountType1 = "";
						int accTypeOption1 = 0;
						while(true) {
							System.out.println("\n--Account types--");
							System.out.println("1. Checking\n"
											+ "2. Savings");
							System.out.println("-----------------");
							System.out.print("Choose a new Account type: ");
							try {
								accTypeOption1 = sc.nextInt();
								System.out.println();
							}
							catch (InputMismatchException e) {
								accTypeOption1 = 0;
						    }
							finally {
								sc.nextLine();
								if(accTypeOption1 < 1 || accTypeOption1 > 2) {
									System.out.println("Please choose a valid option!\n");
								}
								else {
									if(accTypeOption1 == 1)
										accountType1 = "Checking";
									else if(accTypeOption1 == 2)
										accountType1 = "Savings";
									c = cm.updateCustomer(accNum1,accountType1,updateOption) ;
									break;
								}
							}
						}
					}
					break;
					
				
				//3. Delete Customer
				case 3:
					//Account Number Input validation
					int accNum2 = -1;
					while(true){
						try {
							System.out.print("Account Number: ");
							accNum2 = sc.nextInt();
						}
						catch (InputMismatchException e) {
							accNum2 = -1;
					    }
						finally {
							sc.nextLine();
							if(accNum2 < 0 || accNum2 > 9999999) {
								System.out.println("Please enter a valid Account Number!\n");
							}
							else break;
						}
					}
					
					cm.deleteCustomer(accNum2);
					break;
					
					
				//4. Deposit Money
				case 4:
					//Account Number Input validation
					int accNum3 = -1;
					while(true){
						try {
							System.out.print("Account Number: ");
							accNum3 = sc.nextInt();
						}
						catch (InputMismatchException e) {
							accNum3 = -1;
					    }
						finally {
							sc.nextLine();
							if(accNum3 < 0 || accNum3 > 9999999) {
								System.out.println("Please enter a valid Account Number!\n");
							}
							else break;
						}
					}
					
					if(!cm.displayCustomer(accNum3)) break;
					
					//Money Input Validation
					Double amount = -1.0;
					while(true){
						try {
							System.out.print("Enter the deposit amount: $");
							amount = sc.nextDouble();
						}
						catch (InputMismatchException e) {
							amount = -1.0;
					    }
						finally {
							sc.nextLine();
							if(amount < 0.0 || amount > 1000000.0) {
								System.out.println("Please enter the amount only in the range of 0.0 to 1000000.0!\n");
							}
							else break;
						}
					}
					
					cm.depositMoney(accNum3,amount);
					break;
					
					
				//5. Withdraw Money
				case 5:
					//Account Number Input validation
					int accNum4 = -1;
					while(true){
						try {
							System.out.print("Account Number: ");
							accNum4 = sc.nextInt();
						}
						catch (InputMismatchException e) {
							accNum4 = -1;
					    }
						finally {
							sc.nextLine();
							if(accNum4 < 0 || accNum4 > 9999999) {
								System.out.println("Please enter a valid Account Number!\n");
							}
							else break;
						}
					}
					
					if(!cm.displayCustomer(accNum4)) break;
					if(!cm.checkAccountType(accNum4)) break;
					
					//Money Input Validation
					Double amount1 = -1.0;
					while(true){
						try {
							System.out.print("Enter the Withdraw amount: $");
							amount1 = sc.nextDouble();
						}
						catch (InputMismatchException e) {
							amount1 = -1.0;
					    }
						finally {
							sc.nextLine();
							if(amount1 < 0.0 || amount1 > 1000000.0) {
								System.out.println("Please enter the amount only in the range of 0.0 to 1000000.0!\n");
							}
							else break;
						}
					}
					
					cm.withdrawMoney(accNum4,amount1);
					break;
					
					
				//6. Display Customers List
				case 6:
					cm.displayCustomersList();
					break;
					
					
				//7. Exit
				case 7:
					System.out.println("\nThank you!\n");
					exit = true;
					break;
					
			}
			
		}
		
		sc.close();
	}
	
}
