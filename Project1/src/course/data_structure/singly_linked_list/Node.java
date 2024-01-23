package course.data_structure.singly_linked_list;

public class Node {
	
	private int Data;
	private Node next;
	
	public Node() {}

	public Node(int data, Node next) {
		Data = data;
		this.next = next;
	}

	public Node(int data) {
		this(data, null);
	}

	public int getData() {
		return Data;
	}

	public void setData(int data) {
		Data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
}
