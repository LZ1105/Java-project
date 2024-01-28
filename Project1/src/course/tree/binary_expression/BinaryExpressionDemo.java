package course.tree.binary_expression;

public class BinaryExpressionDemo {

	public static void main(String[] args) {
		
		// 30 / (2 + 3) + 4 * (10 - 3)
		BinaryExpression biExp = new BinaryExpression(
				new Node(new Operator('+'),
						new Node(new Operator('/'),
								new Node(new Operand(30)),
								new Node(new Operator('+'), 
										new Node(new Operand(2)), 
										new Node(new Operand(3)))),
						new Node(new Operator('*'),
								new Node(new Operand(4)),
								new Node(new Operator('-'),
										new Node(new Operand(10)),
										new Node(new Operand(3))))));
		
		biExp.print();
		biExp.printExpression();
		int result = biExp.evaluate();
		System.out.println("result = " + result);

	}

}
