package course.queue_and_stack;

public class LukasUnboundedStack implements Stack {
	
	private Integer[] data;
	private int capacity = 0;
	private int size = 0;
	
	public LukasUnboundedStack() {
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
		// TODO: we need to dynamically allocate new space for data[]
		// using doubling strategy.
		// step 1: newData[] = new int[newCapacity];
		// step 2: copy data[] -> newData[]
		// step 3: data = newData;
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
