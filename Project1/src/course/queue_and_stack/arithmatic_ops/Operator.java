package course.queue_and_stack.arithmatic_ops;

public enum Operator {
	
	Add("+"), Subtract("-"), Multiply("*"), Divide("/");
	
	private String sign;
	
	Operator(String sign) {
		this.sign = sign;
	}

}
