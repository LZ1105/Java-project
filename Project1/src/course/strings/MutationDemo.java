package course.strings;

public class MutationDemo {

	public static void main(String[] args) {
		MutableStudent s1 = new MutableStudent("John", "Smith", 30);
		System.out.println("s1 (" + s1.hashCode() + "): " + s1);
		s1.setLastName("Doe");
		System.out.println("s1 (" + s1.hashCode() + "): " + s1);

		ImmutableStudent s2 = new ImmutableStudent("John", "Smith", 30);
		System.out.println("s2 (" + s2.hashCode() + "): " + s2);
		s2 = s2.setLastName("Green");
		System.out.println("s2 (" + s2.hashCode() + "): " + s2);
	}

}
