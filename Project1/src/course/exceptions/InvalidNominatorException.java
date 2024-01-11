package course.exceptions;

public class InvalidNominatorException extends Exception {
	
	private double data;

	public InvalidNominatorException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidNominatorException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidNominatorException(String message, double data) {
		super(message);
		this.data = data;
	}

	public InvalidNominatorException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidNominatorException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidNominatorException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public double getData() {
		return data;
	}
	
}
