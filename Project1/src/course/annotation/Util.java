package course.annotation;

public class Util {
	
	@Deprecated
	void sayHello(String name, String greeting) {
		System.out.printf("Hello, %s. %s\n", name, greeting);
	}

	void sayHello(String name, String greeting, String additionGreeting) {
		System.out.printf("Hello, %s. %s\n", name, greeting);
		if (additionGreeting != null) {
			System.out.println(additionGreeting);
		}
	}

}
