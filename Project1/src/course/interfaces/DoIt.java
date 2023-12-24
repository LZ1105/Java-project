package course.interfaces;

public interface DoIt {
	
	public void func1(int i);
	public void func2(String s);
	public default void func3(int i, String s) {
		func1(i);
		func2(s);
	}
	
	public static String typeName() {
		return "DoIt interface";
	}
}
