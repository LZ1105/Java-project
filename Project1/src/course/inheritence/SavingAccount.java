package course.inheritence;

public class SavingAccount extends Account {
	
	private double interestRate;
	
	public SavingAccount() {}

	public SavingAccount(int accountNumber, double initialDeposit, double interestRate) {
		super();
		this.setAccountNumber(accountNumber);
		this.setBalance(initialDeposit);
		this.interestRate = interestRate;
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
	
}
