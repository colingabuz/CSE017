import java.util.Scanner;
public class TestBank {
	public static void main(String [] args) {
		
		BankAccount [] listAccounts = new BankAccount [5];
		listAccounts[0] = new BankAccount("John Blake", 12534, 1200);
		listAccounts[1] = new BankAccount("Sarah Brown", 44422, 2045);
		listAccounts[2] = new BankAccount("Emma Johnson", 33322, 450);
		listAccounts[3] = new BankAccount("Suzan Jones", 55500, 23000);
		listAccounts[4] = new BankAccount("Mary Chen", 11111, 550);
		
		
		Bank myBank = new Bank("MyBank", "Bethlehem", listAccounts);
		
		double monthlyFee = 20;
		
		
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
						
						boolean valid = false;
						
						while (valid == false)  {
							
			
						
							if (myBank.findAccount(account)) {
								valid = true;
								break;
							}
							
							else {
								if (accNum.matches(regex)) {
									System.out.println("That account number does not exist. Please try again.");
									valid = false;
								}
								
								else {
									System.out.println("Account numbers are five digits long. Please enter another account number. ");
									valid = false;
								}
							}
							
							System.out.println("Enter another account number: ");
							 account = input.nextInt();
							 accNum = Integer.toString(account);
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
							
							
							default: 
								System.out.println("Exiting management menu");
								break;
							}
						
							if (manage == 4) {
								break;
							}
						
						}while(manage > 0 && manage < 5);
					
				
				 break;
				
			case 2:
				
					myBank.applyMonthlyFee(20);
				
				break;
				
			case 3:
				myBank.viewAccounts();
				break;
				
				
			default: 
				System.out.println("Exiting program... ");
				break;
		} 
	} while(op > 0 && op < 4);
}
	
	
	
	
	
	public static int getChoice(Scanner input){
		int operation = 0;
		
	do {
			printOptions();
				if (input.hasNextInt()) {
					operation = input.nextInt();
			
					if (operation > 0 && operation < 5) {
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
	
	
	
	
	
	public static void printOptions() {
		System.out.println("Please select an operation (Main Menu): ");
		System.out.println("1: Manage Account ");
		System.out.println("2: Apply Monthly Fee ");
		System.out.println("3: View All Accounts ");
		System.out.println("4: Exit ");
	}
	
	
	
	public static void printManage() {
		System.out.println("Please select a management operation: ");
		System.out.println("1: View Balance ");
		System.out.println("2: Deposit ");
		System.out.println("3: Withdraw ");
		System.out.println("4: Exit management menu ");
	}
	
	
	
	public static int getManageOption(Scanner input){
		int operation = 0;
		
	do {
			printManage();
				if (input.hasNextInt()) {
					operation = input.nextInt();
			
					if (operation > 0 && operation < 5) {
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

