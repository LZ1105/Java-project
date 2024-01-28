package course.tree;

public class BST {
	
	enum TraversalMode {
		PreOrder, InOrder, PostOrder;
	}
	
	private Node root;
	private int size;
	
	public BST() {}
	
	public BST(int data) {
		root = new Node(data);
	}

	public void insert(int data) {
		
		// Approach #1: using loop
		
		size++;
		
		if (root == null) {
			root = new Node(data);
			return;
		}
		
		Node node = root;
		
		while (node != null) { 
			if (data < node.getData()) {
				if (node.getLeft() == null) {
					node.setLeft(new Node(data));
					break;
				} else {
					node = node.getLeft();
				}
			} else { // data >= node.getData()
				if (node.getRight() == null) {
					node.setRight(new Node(data));
					break;
				} else {
					node = node.getRight();
				}
			}
		}
		
		// TODO: homework
		// Approach #2: using recursion (without Node class)
//		 insert(root, data);

		// TODO: homework
		// Approach #3: using recursion (with Node class)
//		root.insert(data);
	}
	
	private void insert(Node node, int data) {
		// TODO homework
		
	}

	public int size() {
		return size;
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
		System.out.println(prefix + ": " + node.getData()); // current data
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

	public boolean search(int data) {
		// Approach #1: Loop
//		Node node = root;
//		while (node != null) {
//			if (data == node.getData()) {
//				return true;
//			} else if (data < node.getData()) {
//				node = node.getLeft();
//			} else { // data > node.getData()
//				node = node.getRight();
//			}
//		}
//		return false;
		
		// Approach #2: Recursion
//		return search(root, data);
		
		// Approach #3: Recursion with utilization of Node class (O-O)
		return root == null? false : root.search(data);
	}
	
	private boolean search(Node node, int data) {
		if (node == null) { // base condition
			return false; // not found
		} else if (data == node.getData()) {
			return true; // found
		} else if (data < node.getData()){
			return search(node.getLeft(), data);
		} else { // data > node.getData()
			return search(node.getRight(), data);
		}
	}
	
	public void printData(TraversalMode traversalMode) {
		switch (traversalMode) {
		case PreOrder:
			printDataPreOrder(root);
			break;
		case InOrder:
			printDataInOrder(root);
			break;
		case PostOrder:
			printDataPostOrder(root);
			break;
		}
		System.out.println();
	}

	private void printDataPostOrder(Node node) {
		if (node == null) { // base condition
			return;
		}
		printDataPostOrder(node.getLeft());
		printDataPostOrder(node.getRight());
		System.out.print(node.getData() + " ");
	}

	private void printDataInOrder(Node node) {
		if (node == null) { // base condition
			return;
		}
		printDataInOrder(node.getLeft());
		System.out.print(node.getData() + " ");
		printDataInOrder(node.getRight());
	}

	private void printDataPreOrder(Node node) {
		if (node == null) { // base condition
			return;
		}
		System.out.print(node.getData() + " ");
		printDataPreOrder(node.getLeft());
		printDataPreOrder(node.getRight());
	}

	public void delete(int data) {
		// Approach #1: using loop
		Node node = root;
		Node parentNode = null;
		boolean isNodeLeftChild = true;
		
		// step 1: search node
		while (node != null) {
			if (node.getData() == data) {
				// step 2: delete the node 
				deleteNode(parentNode, node, isNodeLeftChild);
				break;
			} else if (data < node.getData()) {
				// search on left child
				parentNode = node;
				isNodeLeftChild = true;
				node = node.getLeft();
			} else { // data > node.getData()
				// search on right child
				parentNode = node;
				isNodeLeftChild = false;
				node = node.getRight();
			}
		}
		
		// TODO: homework
		// Approach #2: using recursion (without engaging Node class)
//		delete(root, data);
	}

	private void deleteNode(Node parentNode, Node node, boolean isNodeLeftChild ) {
		// Case 1: left == right == null
		if (node.getLeft() == null && node.getRight() == null) {
			if (isNodeLeftChild) {
				parentNode.setLeft(null);
			} else {
				parentNode.setRight(null);
			}
		} else if (node.getLeft() == null) {
			// Case 2a: has only right child (i.e., left == null, right != null)
			if (isNodeLeftChild) {
				parentNode.setLeft(node.getRight());
			} else {
				parentNode.setRight(node.getRight());
			}
		} else if (node.getRight() == null) {
			// Case 2b: has only left child (i.e., left != null, right == null)
			if (isNodeLeftChild) {
				parentNode.setLeft(node.getLeft());
			} else {
				parentNode.setRight(node.getLeft());
			}
		} else {
			// Case 3: has both left and right children
			// step 3.1 find the left-most node of the right tree of node
			Node promotingParentNode = null;
			Node promotingNode = node.getRight();
			while (promotingNode.getLeft() != null) {
				promotingParentNode = promotingNode;
				promotingNode = promotingNode.getLeft();
			}
			if (isNodeLeftChild) {
				parentNode.setLeft(promotingNode);
			} else {
				parentNode.setRight(promotingNode);
			}
			promotingNode.setLeft(node.getLeft());
			if (promotingParentNode != null) {
				promotingNode.setRight(node.getRight());
				promotingParentNode.setLeft(null);
			}
		}
	}

	private void delete(Node node, int data) {
		
	}

}
