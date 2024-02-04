package course.tree;

import course.tree.BST.TraversalMode;

public class BSTDemo {

	public static void main(String[] args) {
		
		int testData[] = {120, 30, 150, 20, 110, 100, 90, 125};
		
		BST tree = new BST();
		
		for (int data : testData) {
			tree.insert(data);
		}
		
		System.out.println("bst size = " + tree.size());
		tree.print();
		
		boolean found = tree.search(100);
		System.out.println("Searching 100: " + found);

		found = tree.search(115);
		System.out.println("Searching 115: " + found);
		
		System.out.print("Pre-order: ");
		tree.printData(TraversalMode.PreOrder);

		System.out.print("In-order: ");
		tree.printData(TraversalMode.InOrder);

		System.out.print("Post-order: ");
		tree.printData(TraversalMode.PostOrder);
		
		tree.delete(125);
		System.out.println("After deleting 125");
		tree.print();

		tree.delete(30);
		System.out.println("After deleting 90");
		tree.print();

	}

}
