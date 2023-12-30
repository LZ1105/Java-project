package course.queue_and_stack.arithmatic_ops;

public class Calculator {

	public static void main(String[] args) {
		
		// 3 x (1 + 2) - (7 - 3) / 2
		Expression exp = new Expression(
				Operator.Subtract,
				new Expression(
						Operator.Multiply,
						new Expression(3),
						new Expression(
								Operator.Add,
								new Expression(1),
								new Expression(2))),
				new Expression(
						Operator.Divide,
						new Expression(
								Operator.Subtract,
								new Expression(7),
								new Expression(3)),
						new Expression(2)));
		
		System.out.println(exp); // Expected result: 3 x (1 + 2) - (7 -3) / 2
		System.out.println(exp.calculate()); // Expected result: 5
		
		String expStr = "3 x ( 1 + 2 ) - ( 7 - 3 ) / 2";
		Expression exp2 = readExpression(expStr); // Expected result: exp2 is the same as exp.
	}

	private static Expression readExpression(String expStr) {
		// TODO: utilizing Stack to parse the expStr and return an Expression object
		// that is the same as the "exp" object in the main method. 
		return null;
	}

}
