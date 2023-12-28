package course.object_as_superclass;

public class EqualityDemo {

	public static void main(String[] args) {
		
		int a = 10;
		int b = 10;
		if (a == b) {
			System.out.println("a == b: true");
		} else {
			System.out.println("a == b: false");
		}
		
		Student s1 = new Student("John", "Smith", 30, "M", new Address("100 Finch Ave", "North York", "ON", "M1M 1M1", null));
		Student s2 = new Student("John", "Smith", 30, "M", new Address("200 Finch Ave", "North York", "ON", "M1M 1M1", null));
		
		if (s1 == s2) {
			System.out.println("s1 == s2: true");
		} else {
			System.out.println("s1 == s2: false");
		}

		if (s1.equals(s2)) {
			System.out.println("s1.equals(s2): true");
		} else {
			System.out.println("s1.equals(s2): false");
		}
	}

}
