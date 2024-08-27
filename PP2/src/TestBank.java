import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestBank {
	public static void main (String [] args) {
		Bank myBank = new Bank("myBank", "Bethlehem", 500, "accounts.txt");
		myBank.setMonthlyFee(20.0);
	
		Scanner input = new Scanner (System.in);
		
		int op = 0;
		
		do {
			op = getChoice(input);
			
			switch(op) {
			
			case 1:
				System.out.println("Enter an account number: ");
				
				int account = input.nextInt();
				
				String accNum = Integer.toString(account);
				
				String regex = "\\d{5}";
				
				BankAccount search = myBank.findAccount(account);
				
				boolean valid = false;
				
				
				try {
				while (valid == false)  {
					
				
					if (search == null) {
						
						if (accNum.matches(regex)) {
							System.out.println("That account number does not exist. Please try again.");
							valid = false;
						}
						
						else {
							throw new InvalidAccountNumber("The account number you entered is invalid. ");
						}
						
						System.out.println("Enter another account number: ");
						 account = input.nextInt();
						 accNum = Integer.toString(account);
					}
					
					else {
						valid = true;
					}
				
				}
			}catch(InvalidAccountNumber e) {
					System.out.println(e.getMessage());
				}
					int manage = 0;
					
						do {
							
							manage = getManageOption(input);
							
							switch (manage) {
							
							case 1: 
								double view = myBank.viewBalance(account);
								System.out.println("The balance in this account is : $" + view);
								break;
								
							case 2:
								double deposit = 0.0; 
								System.out.println("Enter an amount you wish to deposit: ");
								deposit = input.nextDouble();
								
								myBank.deposit(account, deposit);
								break;
								
							case 3:
								double withdraw = 0.0; 
								System.out.println("Enter an amount you wish to withdraw: ");
								withdraw = input.nextDouble();
								myBank.withdraw(account, withdraw);
								break;
							
							case 4:
								if (search instanceof SavingsAccount) {
									
								SavingsAccount interest = (SavingsAccount) search;
								System.out.println(interest.getInterest() / 12);
								
								}
								
								else {
									System.out.println("The account you entered is not of type Savings. ");
								}
								break;
								
								
							case 5:
								if (search instanceof InvestmentAccount) {
									InvestmentAccount showProfit = (InvestmentAccount) search;
									double change = showProfit.applyRisk();
									if (change > 0) {
										System.out.printf("%-10s\t%-1.2f\n", "Profit = $", change);
									}
									else {
										System.out.printf("%-10s\t%-1.2f\n", "Loss = $", change);
									}
								}
								else {
									System.out.println("The account you entered is not of type Investment. ");
								}
								break;
								
							case 6:
								break;
							}
							
						}while (manage > 0 && manage < 6);
				
					
						
						
				case 2:
					myBank.applyMonthlyFee(20.0);
					break;
					
					
				case 3: 
					myBank.viewAccounts();
					break;
					
				case 4:
					System.out.println("Enter a minimum balance for accounts you would like to search for: ");
					BankAccount.minBalance = input.nextDouble();
					BankAccount [] filter = myBank.filterAccounts();
					System.out.println("The number of accounts that fit that criterion is " + filter.length + ".");
					System.out.println("Would you like to see the accounts' information? (y/n) ");
					String answer = input.next();
					if(answer.equals("y")) {
						for (int i = 0; i < filter.length; i++) {
							if (filter[i] instanceof SavingsAccount) {
								SavingsAccount toPrint = (SavingsAccount) filter[i]; 
							System.out.printf ("%-20s\t%-15s\t%-15d\t%-15f\t%-15f\n","Savings", filter[i].getName(), filter[i].getAccount(), filter[i].getBalance(), toPrint.getInterest());
							}
							else if (filter[i] instanceof InvestmentAccount) {
								InvestmentAccount toPrint = (InvestmentAccount) filter[i];
								System.out.printf ("%-20s\t%-15s\t%-15d\t%-15f\t%-15s\n","Investment", filter[i].getName(), filter[i].getAccount(), filter[i].getBalance(), toPrint.getAccountType());
							}
							else {
								System.out.printf ("%-20s\t%-15s\t%-15d\t%-15f\n","Regular", filter[i].getName(), filter[i].getAccount(), filter[i].getBalance());
							}
						}
					}
					
					break;
					
					
				case 5:
					myBank.sortAccounts();
					break;
					
				case 6:
				try {
					myBank.saveAccountsToFile("accounts.txt");
				} catch (FileNotFoundException e) {
					System.out.println(e.getMessage());
				}
					System.out.println("Exiting Program... ");
					break;
			}

			
			
			
			
			
		}while (op > 0 && op < 6);
	}
	
	
	
	
	public static void printOptions() {
		System.out.println("Please select an operation (Main Menu): ");
		System.out.println("1: Manage Account ");
		System.out.println("2: Apply Monthly Fee ");
		System.out.println("3: View All Accounts ");
		System.out.println("4: Filter all bank accounts ");
		System.out.println("5: Sort all accounts");
		System.out.println("6: Quit Program");
	}
	
	
	
	public static void printManage() {
		System.out.println("Please select a management operation: ");
		System.out.println("1: View Balance ");
		System.out.println("2: Deposit ");
		System.out.println("3: Withdraw ");
		System.out.println("4: View monthly interest ");
		System.out.println("5: View current profit/loss ");
		System.out.println("6: Quit submenu ");
	}
	
	
	
	public static int getManageOption(Scanner input){
		int operation = 0;
		
	do {
			printManage();
				if (input.hasNextInt()) {
					operation = input.nextInt();
			
					if (operation > 0 && operation < 7) {
						break;
					}
		
					else {
						input.nextLine();
						System.out.println("Invalid operation choice. ");
						continue;
					}
			}
		
			
		}while (true);
			
		return operation;
	}
	
	
	
	public static int getChoice(Scanner input){
		int operation = 0;
		
	do {
			printOptions();
				if (input.hasNextInt()) {
					operation = input.nextInt();
			
					if (operation > 0 && operation < 7) {
						break;
					}
		
					else {
						input.nextLine();
						System.out.println("Invalid operation choice. ");
						continue;
					}
			}
		
			
		}while (true);
			
		return operation;
	}
}
