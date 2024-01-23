package course.data_structure.dynamic_array;

public class DynamicArray {
	
	private int capacity = 2;
	private int data[] = new int[capacity];
	private int size = 0; // size <= capacity
	
	
	public int size() {
		return size;
	}
	
	public int getData(int index) {
		if (index >= 0 && index < size) {
			return this.data[index];
		} else {
			throw new IndexOutOfBoundsException(String.format("index = %d, size = %d", index, size));
		}
	}

	public void setData(int index, int value) {
		if (index >= 0 && index < size) {
			this.data[index] = value;
		} else {
			throw new IndexOutOfBoundsException(String.format("index = %d, size = %d", index, size));
		}
	}
	
	public void addData(int value) {
		if (size == capacity) {
			// doubling
			doubleCapacity();
		}
		this.data[size ++] = value;
	}

	public void insertData(int index, int value) {
		if (size == capacity) {
			// doubling
			capacity *= 2;
			doubleCapacity();
		}
		if (index >= 0 && index <= size) {
			// shift right all data starting from index.
			for (int i = size; i > index; i--) {
				data[i] = data[i - 1];
			}
			data[index] = value;
			size++;
		} else {
			throw new IndexOutOfBoundsException(String.format("index = %d, size = %d", index, size));
		}
	}
	
	// homework
	public void removeData(int index) {
		
	}
	
	public void removeFirst() {
		
	}
	
	public void removeLast() {
		
	}
	

	private void shrinkCapacity() {
		if (capacity > 2) {
			// ....
		}
	}
	
	private void doubleCapacity() {
		capacity *= 2;
		int newData[] = new int[capacity];
		for (int i = 0; i < size; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}
	
	public void printArray() {
		System.out.print("[");
		for (int i = 0; i < size; i++) {
			System.out.print(data[i] + ", ");
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
		
		DynamicArray array = new DynamicArray();
		for (int i = 10; i <= 300; i += 10) {
			array.addData(i);
//			System.out.println("size = " + array.size() + ", capacity = " + array.capacity);
		}
		
		array.printArray();
		
		array.insertData(10, 99);
		array.printArray();

	}

}
