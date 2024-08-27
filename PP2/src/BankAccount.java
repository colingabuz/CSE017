
public class BankAccount implements Filter, Comparable<BankAccount>{
		public String name;
		public int account;
		protected double balance;
		public static double minBalance;
		
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
		
		public boolean equals(BankAccount obj) {
			if(this.getAccount() == obj.getAccount()) {
				return true;
			}
			return false;
		}
		
		public int compareTo(BankAccount obj) {
			if(this.getBalance() == obj.getBalance()) {
				return 0;
			}
			else if (this.getBalance() > obj.getBalance()) {
				return 1;
			}
			else return -1;
		}


		
		public boolean accept() {
			if (this.getBalance() > minBalance) {
				return true;
			}
			return false;
		}
		
	}

