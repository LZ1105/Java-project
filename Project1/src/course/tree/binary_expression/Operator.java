package course.tree.binary_expression;

public class Operator extends Operation {
	
	public char op; // +, -, *, /
	
	public Operator(char op) {
		this.op = op;
	}
	
	@Override
	public String toString() {
		return new String(new char[] {op});
	}

	@Override
	public int evaluate() {
//		switch (op) {
//		case '+':
//			return num1 + num2;
//		case '-':
//			return num1 - num2;
//		case '*':
//			return num1 * num2;
//		case '/':
//			return num1 / num2;
//		default:
//			return 0;
//		}
		return 0;
	}

}
