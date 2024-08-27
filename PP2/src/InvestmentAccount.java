
public class InvestmentAccount extends BankAccount{
	public String accountType;
	
	public InvestmentAccount(){
		name = "";
		account = 0;
		balance = 0.0;
		accountType = "";
	}
	
	public InvestmentAccount(String name, int account, double balance, String accountType) {
		this.name = name;
		this.account = account; 
		this.balance = balance;
		this.accountType = accountType;
	}
	
	
	public void setAccountType(String type) {
		accountType = type;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public double applyRisk(){

	    double amount;

	    double risk = Math.random();

	    double profitLoss = Math.random();

	    amount = balance * profitLoss / 10;

	    if (risk < 0.5)

	      amount = - amount;

	   balance += amount;

	   return amount;

	 }
	
	
	public String toString() {
		return name + "\nAccount: " + account + "\nBalance: " + balance + "\nType: " + accountType;
	}
	
}
