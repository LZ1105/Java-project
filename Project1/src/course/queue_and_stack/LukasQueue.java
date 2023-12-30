package course.queue_and_stack;

/**
 * TODO: manage the front, size (or adding new or changing existing private variables)
 * to fully utilize the data[].
 * @author User
 *
 */
public class LukasQueue implements Queue {
	
	private Integer[] data;
	private int capacity;
	private int size = 0;
	private int front = 0;
	
	public LukasQueue() {
		this(10);
	}
	
	public LukasQueue(int capacity) {
		this.capacity = capacity;
		this.data = new Integer[capacity];
	}
	
	@Override
	public Integer getFront() {
		if (front < size) {
			return data[front++];
		} else {
			return null;
		}
	}
	
	@Override
	public boolean putBack(Integer item) {
		if (size < capacity) {
			this.data[size++] = item;
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public int getSize() {
		return this.size - this.front;
	}

}
