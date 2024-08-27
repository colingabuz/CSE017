
public class Bank {
	private String name;
	private String branch;
	public static double monthlyFee;
	private BankAccount [] bankAccounts;
	
	
	public Bank() { // Constructor
		name = "";
		branch = "";
		bankAccounts = new BankAccount[10];
	}
	
	
	public Bank(String n, String b, BankAccount [] listAccounts) { // Constructor
		name = n;
		branch = b;
		bankAccounts = new BankAccount[listAccounts.length];
			for (int i = 0; i < listAccounts.length; i++) {
				bankAccounts[i] = listAccounts[i];
			}
	}
	
	
	public static double getMonthlyFee() { // Accessor
		return monthlyFee;
	}
	
	
	public void setMonthlyFee(double fee) { // Mutator
		monthlyFee = fee;
	}
	
	public boolean findAccount(int account) { // checks to see if the account exists in the bank
		for (int i = 0; i < bankAccounts.length; i++) {
			if(bankAccounts[i].getAccount() == account) {
				return true;
			}
		}
		return false;
	}
	
	
	public double viewBalance(int account) { // shows the balance for the account requested
		double bal = 0.0;
		for (int i = 0; i < bankAccounts.length; i++) {
			if(bankAccounts[i].getAccount() == account) {
				bal = bankAccounts[i].getBalance();
			}
		}
		return bal;
	}
	
	
	public void deposit(int account, double amount) { // adds the amount chosen to the account given
		for (int i = 0; i < bankAccounts.length; i++) {
			if (bankAccounts[i].getAccount() == account) {
				bankAccounts[i].deposit(amount);
			}
		}
	}
	
	
	public boolean withdraw(int account, double amount) { // subtracts the amount chosen from the account given
		for (int i = 0; i < bankAccounts.length; i++) {
			if (bankAccounts[i].getAccount() == account) {
				return bankAccounts[i].withdraw(amount);
			}
		}
		return false;
	}
	
	
	public void applyMonthlyFee(double monthlyFee) { // adds the monthly fee to all accounts 
		for (int i = 0; i < bankAccounts.length; i++) {
			bankAccounts[i].withdraw(monthlyFee);
		}
	}
	
	
	public void viewAccounts() { // prints all the accounts in a tabular format
		System.out.printf("%-20s\t%-15s\t%-15s\n", "Account Name", "Account Number", "Account Balance");
		System.out.println();
		for (int i = 0; i < bankAccounts.length; i++) {
			System.out.printf ("%-20s\t%-15s\t%-15s\n", bankAccounts[i].getName(), bankAccounts[i].getAccount(), bankAccounts[i].getBalance());
		}
		System.out.println();
	}
}
