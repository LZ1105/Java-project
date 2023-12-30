package course.queue_and_stack;

public class LukasStack implements Stack {
	
	private Integer[] data;
	private int capacity;
	private int size = 0;
	
	public LukasStack() {
		this(10);
	}
	
	public LukasStack(int capacity) {
		this.capacity = capacity;
		this.data = new Integer[capacity];
	}
	
	@Override
	public Integer pop() {
		if (size > 0) {
			return data[size-- - 1];
		} else {
			return null;
		}
	}
	
	@Override
	public boolean push(Integer item) {
		if (size < capacity) {
			this.data[size++] = item;
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public int getSize() {
		return this.size;
	}

}
