import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

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
	
	public Bank(String name, String branch, int maxAccounts, String filename) {
		this.name = name;
		this.branch = branch;
		 bankAccounts = new BankAccount[maxAccounts];
		readAccountsFromFile(filename);
	}
	
	
	public static double getMonthlyFee() { // Accessor
		return monthlyFee;
	}
	
	
	public void setMonthlyFee(double fee) { // Mutator
		monthlyFee = fee;
	}
	
	public BankAccount findAccount(int accountNumber) { // checks to see if the account exists in the bank
		for (int i = 0; i < bankAccounts.length; i++) {
			if(bankAccounts[i].getAccount() == accountNumber) {
				return bankAccounts[i];
			}
		}
		return null;
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
		System.out.printf("%-20s\t%-15s\t%-15s\t%-15s\t%-15s\n", "Type", "Owner", "Number", "Balance", "Interest/Investment");
		System.out.println();
		for (int i = 0; i < bankAccounts.length; i++) {
			if (bankAccounts[i] instanceof SavingsAccount) {
				SavingsAccount toPrint = (SavingsAccount) bankAccounts[i]; 
			System.out.printf ("%-20s\t%-15s\t%-15d\t%-15.2f\t%-15.2f\n","Savings", bankAccounts[i].getName(), bankAccounts[i].getAccount(), bankAccounts[i].getBalance(), toPrint.getInterest());
			}
			else if (bankAccounts[i] instanceof InvestmentAccount) {
				InvestmentAccount toPrint = (InvestmentAccount) bankAccounts[i];
				System.out.printf ("%-20s\t%-15s\t%-15d\t%-15.2f\t%-15s\n","Investment", bankAccounts[i].getName(), bankAccounts[i].getAccount(), bankAccounts[i].getBalance(), toPrint.getAccountType());
			}
			else {
				System.out.printf ("%-20s\t%-15s\t%-15d\t%-15.2f\n","Regular",  bankAccounts[i].getName(), bankAccounts[i].getAccount(), bankAccounts[i].getBalance());
			}
		}
		System.out.println();
	}
	
	
	
	private void readAccountsFromFile(String filename) {
		try{

			   Scanner fileReader = new Scanner(new FileInputStream(filename));

			   int i = 0;
			   
			   while (fileReader.hasNextLine()){ // while there is something to be read

			      String line = fileReader.nextLine(); // read one line from the text file (information for one account)

			      String[ ] items = line.split(" "); // Split the line using the space as the delimiter

			      String type = items[0]; // first word is the type of the account

			      String owner = items[1]; // second word is the account owner

			      int account = Integer.parseInt(items[2]); // convert third item to a number (bank account number)

			      double balance = Double.parseDouble(items[3]); // convert fourth item to a number (balance)

			      BankAccount ba = null; // declare an empty object

			      
			      switch (type){

			         case "Regular": ba = new BankAccount(owner, account, balance); 
			         
			         break; // create an instance of BankAccount

			         case "Savings": double rate = Double.parseDouble(items[4]); // convert fifth item to a number (interest rate)

			                                    ba = new SavingsAccount(owner, account, balance, rate); // create an instance of SavingsAccount
			                                   
			                                    break;

			         case "Investment": String accountType = items[4]; // fifth item in the line is the investment account type

			                                         ba = new InvestmentAccount(owner, account, balance, accountType); // create an instance of InvestmentAccount
			                                         
			                                         break;

			      }

			      bankAccounts[i] = ba; 
			      i++; // assign object ba to the element i in the array bankAccounts (starting from 0)

			   }

			   fileReader.close();

			}

			catch (FileNotFoundException e){
				System.out.println(e.getMessage());
			}
	}
	
	public void saveAccountsToFile(String filename) throws FileNotFoundException{
		
		PrintWriter fileWriter = new PrintWriter(filename);
		
		for(int i=0; i<bankAccounts.length; i++){

		     if (bankAccounts[i] instanceof SavingsAccount){

		        fileWriter.println("Savings " + bankAccounts[i].getName() + " " + bankAccounts[i].getAccount() + " " + 

		                                  bankAccounts[i].getBalance() + " " + ((SavingsAccount) bankAccounts[i]).getInterest());

		     }

		     else if (bankAccounts[i] instanceof InvestmentAccount){        

		        fileWriter.println("Investment " + bankAccounts[i].getName() + " " + bankAccounts[i].getAccount() + " " + 

		                                  bankAccounts[i].getBalance() + " " + ((InvestmentAccount) bankAccounts[i]).getAccountType());

		     }

		    else { // regular account

		        fileWriter.println("Regular " + bankAccounts[i].getName() + " " + bankAccounts[i].getAccount() + " " + bankAccounts[i].getBalance());

		    }

		 }

		fileWriter.close();
	}
	
	public BankAccount [] filterAccounts() {
		int count = 0;
		for (int i = 0; i < bankAccounts.length; i++) {
			if (bankAccounts[i].accept()) {
				count++;		
			}
		}
		BankAccount [] filtered = new BankAccount [count];
		int m = 0;
		for (int j = 0; j < bankAccounts.length; j++) {
			if(bankAccounts[j].accept()) {
				filtered[m] = bankAccounts[j];
				m++;
			}
		}
		
		return filtered;
	}
	
	
	
	public void sortAccounts() {
		java.util.Arrays.sort(bankAccounts);
	}
}
