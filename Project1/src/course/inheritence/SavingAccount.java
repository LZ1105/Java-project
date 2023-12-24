package course.inheritence;

public class SavingAccount extends Account {
	
	private double interestRate;
	
	public SavingAccount() {
		System.out.println("In SavingAccount().");
	}

	public SavingAccount(int accountNumber, double initialDeposit) {
//		super(accountNumber, initialDeposit);
//		this.interestRate = 0.0;
		this(accountNumber, initialDeposit, 0.0);
		System.out.println("In SavingAccount(int, double).");
	}

	public SavingAccount(int accountNumber, double initialDeposit, double interestRate) {
		super(accountNumber, initialDeposit);
//		this.setAccountNumber(accountNumber);
//		this.setBalance(initialDeposit);
		this.interestRate = interestRate;
		System.out.println("In SavingAccount(int, double, double).");
	}
	
	@Override
	public double getBalance() {
		return super.getBalance() + getInterest();
	}

	public double getInterest() {
		return this.interestRate * super.getBalance();
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public String toString() {
		return "SavingAccount " + super.toString() + ", interestRate=" + interestRate + "]";
	}

	@Override
	public String generateStatement() {
		return "This is a Saving Account statement";
	}
	
}
