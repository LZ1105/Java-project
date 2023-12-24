package course.interfaces;

public interface DoIt2 {
	
	public void func1(int i);
	public void func2(String s);
	public default void func3(int i, String s) {
		func2(s);
		func1(i);
	}
	
	public static String typeName() {
		return "DoIt interface";
	}
}
