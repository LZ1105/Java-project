package course.nested_classes.method_ref;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;

import course.nested_classes.Student;

public class MethodRefDemo {

	public static void main(String[] args) {
		
		Student s1 = new Student("John", "Smith", 30, "M");
		
		// Approach 1: use lambda expression
		processStudent(s1, s -> s.setAge(s.getAge() + 1));
		System.out.println("(1): " + s1);
		
		// Approach 2: Method reference: use an existing static method in StudentUtil
		processStudent(s1, StudentUtil::increaseAge);
//		processStudent(s1, s -> StudentUtil.increaseAge(s)); // equivalent to using lambda expression
		System.out.println("(2): " + s1);
				
		// Approach 3: Method reference: use an existing instance method in StudentHandler
		processStudent(s1, new StudentHandler()::increaseAge);
//		processStudent(s1, s -> new StudentHandler().increaseAge(s)); // equivalent to using lambda expression
		System.out.println("(3): " + s1);
		
		// Approach 4: Method reference: using constructor
		Set<Student> studentSet = new HashSet<>();
		studentSet.add(new Student("John", "Smith", 30, "M"));
		studentSet.add(new Student("Mary", "Poppins", 32, "F"));
		studentSet.add(new Student("John", "Brown", 33, "M"));
		studentSet.add(new Student("Steve", "Green", 21, "M"));
		studentSet.add(new Student("Alice", "Smith", 33, "F"));
		
		// regular approach
//		List<Student> studentList = setToListUsingRegularApproach(studentSet, new ArrayList<>());
//		studentList.stream().forEach(System.out::println);
		
//		// using Lambda
//		List<Student> studentList = setToListUsingFunctionalInterface(studentSet, () -> new ArrayList<>());
//		studentList.stream().forEach(System.out::println);
		
		// using method reference via constructor
		List<Student> studentList = setToListUsingFunctionalInterface(studentSet, ArrayList::new);
		studentList.stream().forEach(System.out::println);
		
		@SuppressWarnings("rawtypes")
		List ss = new ArrayList();
	}

	private static List<Student> setToListUsingFunctionalInterface(Set<Student> studentSet, Supplier<List<Student>> supplier) {
		List<Student> stuList = supplier.get();
		for (Student stu : studentSet) {
			stuList.add(stu);
		}
		return stuList;
	}

	private static List<Student> setToListUsingRegularApproach(Set<Student> studentSet, ArrayList<Student> stuList) {
		for (Student stu : studentSet) {
			stuList.add(stu);
		}
		return stuList;
	}

	private static void processStudent(Student s1, Consumer<Student> consumer) {
		
		consumer.accept(s1);
		
	}

}
