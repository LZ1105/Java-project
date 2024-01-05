package course.annotation;

public class DeprecationDemo {

	public static void main(String[] args) {
		
		Util util = new Util();
		func1(util);
		func2(util);
		func3(util);

	}

	private static void func3(Util util) {
		String name = "John";
		util.sayHello(name, "Good morning.", null);
	}

	private static void func2(Util util) {
		util.sayHello("Mary", "How are you?");
	}

	private static void func1(Util util) {
		String greeting = "Have a nice day!";
		util.sayHello("Steve", greeting);
	}

}
