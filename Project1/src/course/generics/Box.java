package course.generics;

public class Box<T> {
	
	private T object;
	
	public void add(T object) {
		this.object = object;
	}
	
	public T get() {
		return this.object;
	}

}
