package course.inheritence;

public class Banking {

	public static void main(String[] args) {
		
//		Account acct1 = new Account(100001, 100);
		ChequingAccount acct2 = new ChequingAccount(100002, 200, 3.99, 2);
		SavingAccount acct3 = new SavingAccount(100003, 0, 0.025);
		
		double moFee = acct2.getMonthlyFee();
		double interest = acct3.getInterest();
		
		Account acct4 = new ChequingAccount(100004, 200, 2.99, 1);
		Account acct5 = new SavingAccount(100005, 0, 0.035);
		
		acct4.deposit(120.0);
		acct5.deposit(20.0);
		
		
		ChequingAccount acct6 = acct2;
		ChequingAccount acct7 = (ChequingAccount) acct4;
		
		System.out.println(((ChequingAccount)acct4).getNumOfFreeTrxs());
		System.out.println(acct7.getNumOfFreeTrxs());
		
//		 acct7 = (ChequingAccount) acct3; // a SavingAccount object IS NOT ChequingAccount
//		acct7 = (ChequingAccount) acct5; // causes ClassCastException
		System.out.println("Acct #7: " + acct7.getBalance());
		
		System.out.println("Account #7: " + acct7);
		
		Account acct8 = mergeAccount(acct4, acct6);
		if (acct8 != null) {
			System.out.println("Account #4: " + acct4);		
			System.out.println("Account #6: " + acct6);
			System.out.println("Account #8: " + acct8);
		}
		
		acct8.withdraw(10);
		acct8.withdraw(10);
		acct8.withdraw(10);
		acct8.withdraw(10);
		System.out.println("Account #8: " + acct8);

		acct3.deposit(1000);
		System.out.println("Account #3: " + acct3);

		Account acct9 = mergeAccount(acct4, acct5);
//		if (acct9 == null) print error;

	}
	
	public static Account mergeAccount(Account acct1, Account acct2) {
		
		if (acct1 instanceof ChequingAccount && acct2 instanceof ChequingAccount) {
			ChequingAccount ca1 = (ChequingAccount) acct1;
			ChequingAccount ca2 = (ChequingAccount) acct2;
			return new ChequingAccount(
					acct1.getAccountNumber(), 
					ca1.getBalance() + ca2.getBalance(),
					Math.max(ca1.getMonthlyFee(), ca2.getMonthlyFee()),
					ca1.getNumOfFreeTrxs() + ca2.getNumOfFreeTrxs());
			
		} else if (acct1 instanceof SavingAccount && acct2 instanceof SavingAccount) {
			SavingAccount sa1 = (SavingAccount) acct1;
			SavingAccount sa2 = (SavingAccount) acct2;
			return new SavingAccount(
					acct1.getAccountNumber(), 
					sa1.getBalance() + sa2.getBalance(),
					(sa1.getInterestRate() + sa2.getInterestRate()) / 2);
		} else {
			System.err.println("Error: cannot merge accounts with different types.");
			return null;
		}
		
	}

}
