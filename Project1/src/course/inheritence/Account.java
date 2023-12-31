package course.inheritence;

public abstract class Account {
	
	private int accountNumber;
	private double balance;
	
	public Account() {
		System.out.println("In Account().");
	}
	
	public Account(int accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		System.out.println("In Account(int, double).");
	}
	
	public abstract String generateStatement();
	
	public void deposit(double amount) {
		this.balance += amount;
	}

	public void withdraw(double amount) {
		this.balance -= amount;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "accountNumber=" + accountNumber + ", balance=" + balance;
	}
	
}
