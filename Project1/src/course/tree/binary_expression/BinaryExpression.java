package course.tree.binary_expression;

public class BinaryExpression {
	
	enum TraversalMode {
		PreOrder, InOrder, PostOrder;
	}
	
	private Node root;
	private int size;
	
	public BinaryExpression() {}
	
	public BinaryExpression(Operation operation) {
		root = new Node(operation);
	}

	public BinaryExpression(Node root) {
		this.root = root;
	}

	public void print() {
		// Approach #1: Recusively call printByLevel()
//		printByLevel(root, 0, "Root");
		
		// Approach #2: Recusively call printByLevel() on Node
		if (root != null) {
			root.printByLevel();
		}

	}
	
	private void printByLevel(Node node, int level, String prefix) {
		printSpaces(level);

		// base condition:
		if (node == null) {
			System.out.println(prefix + ": no data");
			return;
		}
		
		// recursion step:
		System.out.println(prefix + ": " + node.getOperation()); // current data
		// left
//		printSpaces(level);
//		System.out.print("L: ");
		printByLevel(node.getLeft(), level + 1, "L");
		// right
//		printSpaces(level);
//		System.out.print("R: ");
		printByLevel(node.getRight(), level + 1, "R");
	}
	
	private void printSpaces(int level) {
		// print prefix spaces
		for (int i = 0; i < level * 2; i++) {
			System.out.print(" ");
		}
	}

	public void printExpression() {
		// render tree using in-order traversal
		printExpression(root);
		System.out.println();
	}

	private void printExpression(Node node) {
		if (node != null) {
			if (node.getOperation() instanceof Operator) {
				System.out.print("(");
			}
			printExpression(node.getLeft());
			System.out.print(node.getOperation());
			printExpression(node.getRight());
			if (node.getOperation() instanceof Operator) {
				System.out.print(")");
			}
		}
	}

	public int evaluate() {
		// Approach #1: using post-order style to traversal
		return evaluate(root);
		
		// Approach #2: using O-O polymurphim
//		return root.getOperation().evaluate(); // TODO: finish in the next class. 
	}

	private int evaluate(Node node) {
		if (node.getOperation() instanceof Operand) {
			return ((Operand) node.getOperation()).data;
		} else { // node.getOperation() instanceof Operator
//			+ (left) (right)
			Operator operator = (Operator) node.getOperation();
			return caluclate(operator.op, evaluate(node.getLeft()), evaluate(node.getRight()));
		}
	}

	private int caluclate(char op, int num1, int num2) {
		switch (op) {
			case '+':
				return num1 + num2;
			case '-':
				return num1 - num2;
			case '*':
				return num1 * num2;
			case '/':
				return num1 / num2;
			default:
				return 0;
		}
	}


//	public void printData(TraversalMode traversalMode) {
//		switch (traversalMode) {
//		case PreOrder:
//			printDataPreOrder(root);
//			break;
//		case InOrder:
//			printDataInOrder(root);
//			break;
//		case PostOrder:
//			printDataPostOrder(root);
//			break;
//		}
//		System.out.println();
//	}
//
//	private void printDataPostOrder(Node node) {
//		if (node == null) { // base condition
//			return;
//		}
//		printDataPostOrder(node.getLeft());
//		printDataPostOrder(node.getRight());
//		System.out.print(node.getData() + " ");
//	}
//
//	private void printDataInOrder(Node node) {
//		if (node == null) { // base condition
//			return;
//		}
//		printDataInOrder(node.getLeft());
//		System.out.print(node.getData() + " ");
//		printDataInOrder(node.getRight());
//	}
//
//	private void printDataPreOrder(Node node) {
//		if (node == null) { // base condition
//			return;
//		}
//		System.out.print(node.getData() + " ");
//		printDataPreOrder(node.getLeft());
//		printDataPreOrder(node.getRight());
//	}


}
