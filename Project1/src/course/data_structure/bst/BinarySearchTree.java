package course.data_structure.bst;

public class BinarySearchTree {
	
	Node root = null;

	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(100);
		bst.insert(33);
		bst.insert(22);
		bst.insert(66);
		
		return;

	}

	private void insert(int value) {
		Node newNode = new Node(value);
		if (root == null) {
			root = newNode;
		} else {
			insert(root, newNode);
		}
	}

	private void insert(Node node, Node newNode) {
		if (newNode.getData() < node.getData()) {
			if (node.getLeft() == null) {
				node.setLeft(newNode);
			} else { // node.getLeft() != null
				insert(node.getLeft(), newNode);
			}
		} else { // value >= node.getData()
			if (node.getRight() == null) {
				node.setRight(newNode);
			} else { // node.getLeft() != null
				insert(node.getRight(), newNode);
			}
		}
	}

}
