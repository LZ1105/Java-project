package course.tree;

public class Node {
	private int data;
	private Node left;
	private Node right;
	
//	public Node() {}
	
	public Node(int data) {
		this(data, null, null);
	}

	public Node(int data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
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

	public boolean search(int data) {
//		if (this == null) { // this is never null
//			return false;
//		}
		if (this.data == data) {
			return true;
		} else if (data < this.data) {
			if (this.left == null) {
				return false; // base condition
			} else {
				return this.left.search(data);
			}
		} else { // data > this.data
			return right == null ? false : this.right.search(data);
		}
	}

	public void printByLevel() {
		printByLevel(0, "Root");
	}
	
	private void printByLevel(int level, String prefix) {
		printSpaces(level);
		
		// recursion step:
		System.out.println(prefix + ": " + data); // current data
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

	public void insert(int data) {
		// TODO homework
		
	}
	
}
