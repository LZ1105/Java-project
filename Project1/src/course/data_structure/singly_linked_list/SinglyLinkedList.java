package course.data_structure.singly_linked_list;

public class SinglyLinkedList {
	
	private Node front;
	private int size;
	
	public void add(int value) {
		Node newNode = new Node(value);
		if (front == null) {
			front = newNode;
		} else {
			Node lastNode = front;
			while (lastNode.getNext() != null) {
				lastNode = lastNode.getNext();
			}
			lastNode.setNext(newNode);
		}
		size++;
	}
	
	public void insert(int index, int value) {
		Node newNode = new Node(value);
		if (front == null) {
			front = newNode;
		} else {
			Node node1 = null;
			Node node2 = front;
			while(index > 0 && node2 != null) {
				node1 = node2;
				node2 = node2.getNext();
				index--;
			}
			// Now, we need to insert newNode between node1 and node2
			if (node1 == null) {
				front = newNode;
			} else {
				node1.setNext(newNode);
			}
			newNode.setNext(node2);
		}
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
		Node node = front;
		System.out.print("[");
		while (node != null) {
			System.out.print(node.getData() + ", ");
			node = node.getNext();
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		
		SinglyLinkedList llist = new SinglyLinkedList();
		llist.add(10);
		llist.add(20);
		llist.add(30);
		llist.add(40);
		llist.add(50);
		llist.add(60);
		llist.print();
		
		llist.insert(2, 99);
		llist.print();

		llist.insert(0, 199);
		llist.print();

		llist.insert(8, 299);
		llist.print();
		
		llist.insert(20, 399);
		llist.print();
	}

}
