package course.inheritence.hiding;

public class Demo {

	public static void main(String[] args) {
		SubClass1 sb1 = new SubClass1();
		sb1.setA(100);
		sb1.setA("Good morning");
		sb1.setB(200);
		sb1.printData();
		System.out.println("Type: " + SubClass1.typeOf());

	}

}
