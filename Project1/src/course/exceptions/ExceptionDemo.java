package course.exceptions;

public class ExceptionDemo {

	public static void main(String[] args) {
		
		try {
			double r = func1("10", "10");
			System.out.println("r = " +  r);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static double func1(String n1, String n2) throws ServiceException  {
		try {
			int len1 = n1.length();
			int len2 = n2.length();
			System.out.println("len = " + len1 + len2);
			double a = Double.parseDouble(n1);
			double b = Double.parseDouble(n2);
			return funcA(a, b);
//		} catch (NumberFormatException e) {
//			System.out.println("Error: " + e.getMessage());
////			return 0.0;
//			throw e;
//		} catch (NullPointerException e) {
//			System.out.println("Error: " + e.getMessage());
////			return 0.0;
//			throw new ServiceException(e);
		} catch (InvalidNominatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceException(e);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}

	private static double funcA(double a, double b) throws InvalidNominatorException, ServiceException {
		try {
			openFile();
			double p1 = a + b;
			double p2 = a - b;
			double r = funcB(p1, p2);
			// ... ...
			return r;
		} catch (ZeroDenominatorException e) {
			// strategy #1: keep quite, do nothing.
			e.printStackTrace();
			return 0.0;
		} catch (InvalidNominatorException e) {
			// strategy #2: escalate the exception (possibly do something)
			e.printStackTrace();
			throw e;
		} catch (InvalidDenominatorException e) {
			// strategy #3: escalate with translating/wrapping it in another exception object.
			// optionally, do something before throwing the new exception.
			e.printStackTrace();
			throw new ServiceException(e);
		} catch (Exception e) {
			// have a more generic Exception class here for handling other exceptions.
			throw new ServiceException(e);
		} finally {
			closeFile();
		}
	}
	
	private static void openFile() {System.out.println("File is opened.");}
	private static void closeFile() {System.out.println("File is closed.");}

	private static double funcB(double p1, double p2) throws ZeroDenominatorException, InvalidNominatorException, InvalidDenominatorException {
		if (p2 == 0.0) {
			throw new ZeroDenominatorException();
		}
		if (p1 < 0.0) {
			throw new InvalidNominatorException("Nominator cannot be a negative number.", p1); 
		}
		if (p2 >= 100.0) {
			throw new InvalidDenominatorException("Denominator is too big (it should be less than 100).", p2);
		}
		double result = p1 / p2;
		return result;
	}

}
