package course.generics;

public class BoxDemo {

	public static void main(String[] args) {
		
		Box<Integer> integerBox = new Box<Integer>();
		integerBox.add(100);
		int r = integerBox.get();
		System.out.println("r = " + r);

	}

}
