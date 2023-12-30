package course.nested_classes;

public class ClassWithInitializer {
	
	static int staticInt = 100;
	int instanceInt = 200;
	
	{
		System.out.println("in initializer(1): instanceInt = " + instanceInt);
		instanceInt = 202;
	}
	
	static {
		System.out.println("in staticInt(1): instanceInt = " + staticInt);
		staticInt = 102;
	}
	
	public ClassWithInitializer() {
		System.out.println("in constructor: staticInt = " + staticInt);
		System.out.println("in constructor: instanceInt = " + instanceInt);
		staticInt = 101;
		instanceInt = 201;
	}
	
	static {
		System.out.println("in staticInt(2): instanceInt = " + staticInt);
		staticInt = 103;
	}
	
	{
		System.out.println("in initializer(2): instanceInt = " + instanceInt);
		instanceInt = 203;
	}
	
	public static void main(String[] args) {
		ClassWithInitializer obj
			= new ClassWithInitializer();
		System.out.println("main: staticInt = " + obj.staticInt);
		System.out.println("main = " + obj.instanceInt);
	}

	{
		System.out.println("in initializer(3): instanceInt = " + instanceInt);
		instanceInt = 206;
	}
	
	static {
		System.out.println("in staticInt(3): instanceInt = " + staticInt);
		staticInt = 106;
	}
	
	
}
