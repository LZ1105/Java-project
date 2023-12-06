package course.overloading;

public class OverloadingDemo {

	public static void main(String[] args) {
		
		OverloadingDemo demo = new OverloadingDemo();
		
		int result = demo.add(10, 20, 30);
		System.out.println("result = " + result);
		
		String name = demo.add("Smith", "John");
		System.out.println("name = " + name);
		
	}
	
	private int add(int num1, int num2) {
		return num1 + num2;
	}

	private int add(int num1, int num2, int num3) {
		return num1 + num2 + num3;
	}
	
	private String add(String s1, String s2) {
		return s1 + ", " + s2;
	}
	
	private String add(String s, int i) {
		return s + Integer.toString(i);
	}

	private String add(int i, String s) {
		return Integer.toString(i) + s;
	}

	// duplicate overloads
//	private int add(String name, int age) {
//		return name + ": " + Integer.toString(age);
//	}
}
