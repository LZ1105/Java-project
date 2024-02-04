package course.tree.binary_expression;

public class Node {
	private Operation operation;
	private Node left;
	private Node right;
	
//	public Node() {}
	
	public Node(Operation operation) {
		this(operation, null, null);
	}

	public Node(Operation operation, Node left, Node right) {
		this.operation = operation;
		this.left = left;
		this.right = right;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public void printByLevel() {
		printByLevel(0, "Root");
	}
	
	private void printByLevel(int level, String prefix) {
		printSpaces(level);
		
		// recursion step:
		System.out.println(prefix + ": " + operation); // current data
		if (left != null) {
			left.printByLevel(level + 1, "L");
		} else { // base condition
			printSpaces(level + 1);
			System.out.println("L: no data");
		}
		if (right != null) {
			right.printByLevel(level + 1, "R");
		} else { // base condition
			printSpaces(level + 1);
			System.out.println("R: no data");
		}
	}
	
	private void printSpaces(int level) {
		// print prefix spaces
		for (int i = 0; i < level * 2; i++) {
			System.out.print(" ");
		}
	}
	
}
