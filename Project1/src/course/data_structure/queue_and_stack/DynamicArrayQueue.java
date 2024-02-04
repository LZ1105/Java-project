package course.data_structure.queue_and_stack;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

import course.data_structure.dynamic_array.DynamicArray;

// TODO: create 2-3 more Queue's implementation using singly-linked-list, doubly-linked-list and circular-linked-list.
// TODO: create 2-3 more Stack's implementation using singly-linked-list, doubly-linked-list and circular-linked-list.
public class DynamicArrayQueue implements Queue<Integer> {
	
	private DynamicArray data = new DynamicArray();

	@Override
	public int size() {
		return data.size();
	}

	@Override
	public boolean isEmpty() {
		return data.size() == 0;
	}

	@Override
	public boolean contains(Object o) {
		if (o == null) return false;
		if (! (o instanceof Integer)) {
			return false;
		}
		Integer value = (Integer) o;
		for (int i = 0; i < size(); i++) {
			if (data.getData(i) == value) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<Integer> iterator() {
		return null;
	}

	@Override
	public Integer[] toArray() {
		Integer array[] = new Integer[size()];
		for (int i = 0; i < size(); i++) {
			array[i] = data.getData(i);
		}

		return array;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Integer> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public void clear() {
		data = new DynamicArray();
	}

	@Override
	public boolean add(Integer e) {
		data.addData(e);
		return true;
	}

	@Override
	public boolean offer(Integer e) {
		return add(e);
	}

	@Override
	public Integer remove() {
		if (size() > 0) {
			int value = data.getData(0);
			data.removeFirst();
			return value;
		} else {
			throw new RuntimeException("The queue is empty, cannot remove.");
		}
	}

	@Override
	public Integer poll() {
		if (size() <= 0) {
			return null;
		}
		return remove();
	}

	@Override
	public Integer element() {
		if (size() <= 0) {
			throw new RuntimeException("The queue is empty, cannot run element().");
		}
		return data.getData(0);
//		return null;
	}

	@Override
	public Integer peek() {
		if (size() <= 0) {
			return null;
		}
		return element();
	}
	
	public static void main(String[] args) {
		DynamicArrayQueue queue = new DynamicArrayQueue();
		queue.offer(10);
		queue.offer(20);
		queue.offer(30);
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}

}
