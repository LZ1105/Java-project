package course.interfaces;

public class MyDoIt implements DoIt, DoIt2 {

	@Override
	public void func1(int i) {
		System.out.println("integer: i = " + i);

	}

	@Override
	public void func2(String s) {
		System.out.println("String: s = " + s);

	}

	@Override
	public void func3(int i, String s) {
		System.out.printf("Integer: i = %d, String: s = %s%n", i, s);
	}

}
