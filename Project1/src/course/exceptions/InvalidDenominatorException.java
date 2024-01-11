package course.exceptions;

public class InvalidDenominatorException extends Exception {
	
	private double data;

	public InvalidDenominatorException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidDenominatorException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidDenominatorException(String message, double data) {
		super(message);
		this.data = data;
	}

	public InvalidDenominatorException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidDenominatorException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidDenominatorException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public double getData() {
		return data;
	}
	
}
