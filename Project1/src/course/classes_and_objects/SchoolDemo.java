package course.classes_and_objects;

public class SchoolDemo {
	
	public static void main(String[] args) {
		int a = 10, b = 20;
		int c = add(a, b);
		System.out.println(a + " + " + b + " = " + c); // 10 + 20 = 30 (yes), 20 + 30 = 30 (no)
		
		
//		Student s1 = new Student();
//		s1.firstName = "Lucas";
//		s1.lastName = "Zhang";
//		s1.age = 16;
//		s1.gender = "Male";
		Student s1 = new Student("Lucas", "Zhang", 16, "Male");
		
		Student s2 = new Student();
		s2.setFirstName("Mary");
		s2.setLastName("Poppins");
		s2.setAge(30);
		s2.setGender("Female");
		
		System.out.println("s1 = " + s1);
		s1.print();
		s2.print();
//		printStudent(s1);
//		printStudent(s1);
//		printStudent(s2);
		
		variableScopeDemo();
		
		AshburyStudent.schoolName = "Ashbury HS";
		AshburyStudent lucas = new AshburyStudent("Lucas", "Zhang", 16, "Male");
		AshburyStudent mary = new AshburyStudent("Mary", "Poppins", 30, "Female");
		System.out.println("lucas = " + lucas);
		System.out.println("mary = " + mary);
		System.out.println("lucas = " + lucas);
//		lucas.print();
//		mary.print();
		
		Circle c1 = new Circle(0, 0, 1.5);
		System.out.println("c1's perimeter: " + c1.getPerimeter() + ", area: " + c1.getArea());
		
		Circle.setPI(30);
		
		Circle c2 = new Circle(10, 10, 3);
		System.out.println("c2's perimeter: " + c2.getPerimeter() + ", area: " + c2.getArea());
	}
	
	private static void variableScopeDemo() {
		
		int a = 10;
		System.out.println("a = " + a);
		
//		int c = 100;
		int b = 20;
		if (b > 10) {
			int c = 30;
			System.out.println("c = " + c);
			System.out.println("a = " + a);
		}
//		b = c + 1; // c must be declared in the enclosing block and before this line.
		
	}

	// Parameters a and b are passed following copy-by-value
	private static int add(int a, int b) { // a = 10, b = 20
		int r = 0;
		r = a + b; // r = 30
		a *= 2; // a = 20
		b += 10; // b = 30
		System.out.println("a = " + a + ", b = " + b); // a = 20, b = 30
		return r; // r = 30
	}

	// The Parameter is passed  by reference (still follow the copy-by-value rule, but the value here refers to reference of the Student object s.
	public static void printStudent(Student s) {
		System.out.println("Student: name = " + s.getFirstName() + " " + s.getLastName() + ", age = " + s.getAge() + ", gender = " + s.getGender());
//		s = new Student();
		s.setFirstName("Nobody");
		s.setLastName("Unknown");
		s.setAge(100);
		s.setGender("Don't know");
		System.out.println("Student: name = " + s);
	}

}
