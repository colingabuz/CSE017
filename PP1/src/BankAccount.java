
public class BankAccount {
	private String name;
	private int account;
	private double balance;
	
	public BankAccount() {
		name = "";
		account = 0; 
		balance = 0.0;
	}
	
	
	public BankAccount(String n, int a, double b) {
		name = n;
		account = a;
		balance = b;
	}
	
	
	public String getName() {
		return name;
	}
	
	public int getAccount() {
		return account;
	}
	
	
	public double getBalance() {
		return balance;
	}
	
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public boolean withdraw(double amount) {
		if (balance - amount > 0) {
			balance -= amount;
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		String num = Integer.toString(account);
		
		String bal = Double.toString(balance);
		
		String info = name + "  " + num + "  " + bal;
		
		return info;
	}
	
	
	
}
