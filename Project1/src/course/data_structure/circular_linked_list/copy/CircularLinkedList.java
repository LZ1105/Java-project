package course.data_structure.circular_linked_list.copy;

public class CircularLinkedList {
	
	private Node head;
	private int size;
	
	public void addFront(int value) {
		Node newNode = new Node(value);
		// TODO: ... ...
		size++;
	}
	
	public void addBack(int value) {
	}
	
	public void insert(int index, int value) {
		if (index < 0) {
			throw new RuntimeException("Invalid index of " + index);
		}
		if (index == 0 || head == null) {
			addFront(value);
		} else if (index >= size) {
			addBack(value);
		}
		Node newNode = new Node(value);
		// TODO: ...
		
	}
	
	public void remove(int index) {
		
	}

	
	public int size() {
//		// O(n)
//		int size = 0;
//		Node node = front;
//		while (node != null) {
//			size++;
//			node = node.getNext();
//		}
		// O(1)
		return size;
	}
	
	
	public void print() {
		// TODO: revise the following code for Circular Linked List
		Node node = head;
		System.out.print("[");
		while (node != null) {
			System.out.print(node.getData() + ", ");
			node = node.getNext();
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		
		CircularLinkedList llist = new CircularLinkedList();
		llist.addFront(10);
		llist.addFront(20);
		llist.addBack(30);
		llist.addFront(40);
		llist.addBack(50);
		llist.addBack(60);
		llist.print();
		
		llist.insert(2, 100);
		llist.print();
		
//		llist.insert(2, 99);
//		llist.print();
//
//		llist.insert(0, 199);
//		llist.print();
//
//		llist.insert(8, 299);
//		llist.print();
//		
//		llist.insert(20, 399);
//		llist.print();
	}


}

