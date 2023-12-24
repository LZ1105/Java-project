package course.inheritence.hiding;

public class SubClass1 extends SuperClass {
	
	protected int b = 20;
	protected String a = "Hello"; // hiding the variable "a" defined in SuperClass (not recommended)
	
	public int getB() {
		return b;
	}


	public void setB(int b) {
		this.b = b;
	}
	
//	public String getA() {
//		return a;
//	}

	public void setA(String a) {
		this.a = a;
	}


	public void printData() {
		System.out.println("super's a = " + super.a);
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}
	
	// hiding the static method "typeOf" defined in SuperClass (does not violate any OO principles)
	public static String typeOf() {
		return "SubClass";
	}

}
