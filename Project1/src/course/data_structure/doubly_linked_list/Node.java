package course.data_structure.doubly_linked_list;

public class Node {
	
	private int Data;
	private Node prior;
	private Node next;
	
	public Node() {}

	public Node(int data, Node prior, Node next) {
		Data = data;
		this.prior = prior;
		this.next = next;
	}

	public Node(int data) {
		this(data, null, null);
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

	public Node getPrior() {
		return prior;
	}

	public void setPrior(Node prior) {
		this.prior = prior;
	}
	
}
