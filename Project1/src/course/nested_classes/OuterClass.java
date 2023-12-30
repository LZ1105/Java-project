package course.nested_classes;

public class OuterClass {
	
	private static int staticIntValue = 100;
	private int nonStaticIntValue = 200;
	
	void func1() {
		class LocalClass {
//			private static int staticLocalInstanceVariable = 10; // local class cannot define static members.
			void funcL1() {
				System.out.println("outerclass' staticIntValue = " + staticIntValue);
				System.out.println("outerclass' nonStaticIntValue = " + nonStaticIntValue);
			}
		}
		new LocalClass().funcL1();
	}
	
	public static class StaticInnerClass {
		
		private static int staticIntValueInsideClass = 300;
		private int nonStaticIntValueInsideClass = 400;
		
		void doTask1() {
			System.out.println("staticIntValueInsideClass = " + staticIntValueInsideClass);
			System.out.println("nonStaticIntValueInsideClass = " + nonStaticIntValueInsideClass);
			System.out.println("outerclass' staticIntValue = " + staticIntValue);
//			System.out.println("outerclass' nonStaticIntValue = " + nonStaticIntValue); // cannot access a non-static member in the outer class from a static inner class.
		}
		
	}

	public class InnerClass {
		
//		private static int staticIntValueInsideClass = 300; // Cannot define static members in a non-static inner class.
		private int nonStaticIntValueInsideClass = 400;
		
		void doTask1() {
//			System.out.println("staticIntValueInsideClass = " + staticIntValueInsideClass);
			System.out.println("nonStaticIntValueInsideClass = " + nonStaticIntValueInsideClass);
			System.out.println("outerclass' staticIntValue = " + staticIntValue);
			System.out.println("outerclass' nonStaticIntValue = " + nonStaticIntValue);
		}
		
	}
}
