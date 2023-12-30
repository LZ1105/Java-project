package course.nested_classes;

public class InnerClassDemo {

	public static void main(String[] args) {
		
		Student.Address addr = new Student.Address();
		Student s = new Student("John", "Doe", 33, "M", addr);
		
		OuterClass.StaticInnerClass obj1 = new OuterClass.StaticInnerClass();
		OuterClass.InnerClass obj2 = new OuterClass().new InnerClass();

	}

}
