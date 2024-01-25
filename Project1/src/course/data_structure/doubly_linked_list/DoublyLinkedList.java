package course.data_structure.doubly_linked_list;

public class DoublyLinkedList {
	
	private Node head, tail;
	private int size;
	
	public void addFront(int value) {
		Node newNode = new Node(value);
		if (head == null) {
//			newNode.setNext(null);	// Redundant
			tail = newNode;
		} else {
			newNode.setNext(head); // 1
			head.setPrior(newNode); // 2
		}
		head = newNode;			// 3
		newNode.setPrior(null);	// 4
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
		} else if (index >= size || tail == null) {
			addBack(value);
		}
		Node newNode = new Node(value);
		
		Node node1 = null;
		Node node2 = head;
		while(index > 0 && node2 != null) {
			node1 = node2;
			node2 = node2.getNext();
			index--;
		}

		node1.setNext(newNode);
		newNode.setNext(node2);
		newNode.setPrior(node1);
		node2.setPrior(newNode);
		
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
		Node node = head;
		System.out.print("head->tail: [");
		while (node != null) {
			System.out.print(node.getData() + ", ");
			node = node.getNext();
		}
		System.out.print("], tail->head: [");
		node = tail;
		while (node != null) {
			System.out.print(node.getData() + ", ");
			node = node.getPrior();
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		
		DoublyLinkedList llist = new DoublyLinkedList();
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

