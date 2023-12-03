package course.inheritence;

public class ChequingAccount extends Account {
	
	private double monthlyFee;
	private int numOfFreeTrxs;
	private int numOfTrxs = 0;
	
	public ChequingAccount() {}

	public ChequingAccount(int accountNumber, double initialDeposit, double monthlyFee, int numOfFreeTrxs) {
		super();
		this.setAccountNumber(accountNumber);
		this.setBalance(initialDeposit);
		this.monthlyFee = monthlyFee;
		this.numOfFreeTrxs = numOfFreeTrxs;
	}
	
	@Override
	public void withdraw(double amount) {
		super.withdraw(amount);
		this.numOfTrxs ++;
	}
	
	@Override
	public double getBalance() {
		return super.getBalance() - (numOfTrxs > numOfFreeTrxs ? this.monthlyFee : 0);
	}

	public double getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(double monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

	public int getNumOfFreeTrxs() {
		return numOfFreeTrxs;
	}

	public void setNumOfFreeTrxs(int numOfFreeTrxs) {
		this.numOfFreeTrxs = numOfFreeTrxs;
	}
	
	public int getNumOfTrxs() {
		return numOfTrxs;
	}

	public void setNumOfTrxs(int numOfTrxs) {
		this.numOfTrxs = numOfTrxs;
	}

	@Override
	public String toString() {
		return "ChequingAccount [" + super.toString() + ", monthlyFee=" + monthlyFee + ", numOfFreeTrxs=" + numOfFreeTrxs + ", numOfTrxs="
				+ numOfTrxs + "]";
	}


}
