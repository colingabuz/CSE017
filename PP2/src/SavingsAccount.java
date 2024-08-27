
public class SavingsAccount extends BankAccount{
	private double yearlyInterest;
	
	public SavingsAccount() {
		name = "";
		account = 0;
		balance = 0.0;
		yearlyInterest = 0.0;
	}
	
	
	public SavingsAccount(String name, int account, double balance, double interest) {
		this.name = name;
		this.account = account;
		this.balance = balance;
		yearlyInterest = interest;
	}
	
	public double applyMonthlyInterest() {
		double monthlyInterest = balance * ((yearlyInterest / 12) / 100);
		return balance + monthlyInterest;
	}
	
	public String toString() {
		return name + "\nAccount: " + account + "\nBalance: " + "\nInterest Rate: " + yearlyInterest;
	}
	
	
	public void setYearlyInterest(double interest) {
		yearlyInterest = interest;
	}
	
	public double getInterest() {
		return yearlyInterest;
	}
	
}
