package course.nested_classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaDemo {

	public static void main(String[] args) {
		Set<Student> students = new HashSet<>();
		students.add(new Student("John", "Smith", 30, "M"));
		students.add(new Student("Mary", "Poppins", 32, "F"));
		students.add(new Student("John", "Brown", 33, "M"));
		students.add(new Student("Steve", "Green", 21, "M"));
		students.add(new Student("Alice", "Smith", 33, "F"));
		
		printStudentsOlderThan(students, 30);
		printStudentsAgeBetween(students, 30, 32);
		
		// Usinge an anonymous inner class
		printStudentsSatisfying(students, "Student (male)", new CheckPerson<Student>() {

			@Override
			public boolean check(Student s) {
				return "M".equals(s.getGender());
			}
			
		});
		
		// Using lambda expression, since CheckPerson is a functional interface (i.e., defines only ONE abstract method) 
		printStudentsSatisfying(students, "Student (male - 1)", (Student s) -> {
				return "M".equals(s.getGender());
			}
		);
		printStudentsSatisfying(students, "Student (male - 2)", s -> "M".equals(s.getGender()));
		printStudentsSatisfyingWithPredicate(students, "Student (male - 3)", s -> "M".equals(s.getGender()));
		
		processStudents(students, s -> "F".equals(s.getGender()), s -> {
			System.out.println("Female student: " + s);
		});

//		int total = 0;
		class StudentStatistics { 
			protected int total;
		}
		StudentStatistics stat = new StudentStatistics();
		processStudents(students, s -> s.getAge() <= 30, s -> {
//			total ++;
			stat.total ++;
		});
		System.out.println("Total # of students younger than 30: " + stat.total);
		
		List<String> studentNames = new ArrayList<>();
		processStudents(
				students, 
				s -> s.getAge() >= 30, 
				s -> s.getFirstName() + " " + s.getLastName(),
				name -> studentNames.add(name));
		System.out.println("Student names: " + studentNames);
		
		List<String> studentNames2 = new ArrayList<>();
		students
			.stream()
			.filter(s -> s.getAge() >= 30)
			.map(s -> s.getLastName() + ", " + s.getFirstName())
			.forEach(name -> studentNames2.add(name));
		System.out.println("Student names (2): " + studentNames2);
		
		Student students2[] = {
				new Student("John", "Smith", 30, "M"),
				new Student("Mary", "Poppins", 32, "F"),
				new Student("John", "Brown", 33, "M"),
				new Student("Steve", "Green", 21, "M"),
				new Student("Alice", "Smith", 33, "F")};
		
		List<String> studentNames3 = new ArrayList<>();
		Arrays
			.stream(students2)
			.filter(s -> testOnNameAndAge(s, (name, age) -> "John".equals(s.getFirstName()) && s.getAge() == 33))
			.map(s -> s.getLastName() + ", " + s.getFirstName())
			.forEach(name -> studentNames3.add(name));
		System.out.println("Student names (3): " + studentNames3);
		
		// The following two declarations are identical.
		// The first one is using anonymous inner class, 
		// the second one is using lambda expression.
		DataChecker oddDataChecker = new DataChecker() {
			int x = 100;
			@Override
			public boolean isGoodData(int data) {
				System.out.println("this.x = " + this.x);
				return data %2 != 0;
			}
		};
		
		DataChecker oddDataChecker2 = data -> data %2 != 0;
		
		System.out.println("-----------------------");
		processStudents(students, s -> "F".equals(s.getGender()), System.out::println);

	}
	
	private static  boolean testOnNameAndAge(Student stu, BiPredicate<String, Integer> checker) {
		return checker.test(stu.getFirstName(), stu.getAge());
	}

	private static <S, T> void processStudents(
			Set<S> students, 
			Predicate<S> checker,
			Function<S, T> mapper,
			java.util.function.Consumer<T> handler) {
		for (S s: students) {
			if (checker.test(s)) {
				handler.accept(mapper.apply(s));
			}
		}
	}
	

//	private static void processStudents(
//			Set<Student> students, 
//			Predicate<Student> checker,
//			Function<Student, String> mapper,
//			java.util.function.Consumer<String> handler) {
//		for (Student s: students) {
//			if (checker.test(s)) {
//				handler.accept(mapper.apply(s));
//			}
//		}
//	}

	private static void processStudents(Set<Student> students, Predicate<Student> checker, java.util.function.Consumer<Student> handler) {
		for (Student s: students) {
			if (checker.test(s)) {
				handler.accept(s);
			}
		}
	}

	private static void printStudentsSatisfyingWithPredicate(Set<Student> students, String prefix, Predicate<Student> checker) {
		for (Student s: students) {
			if (checker.test(s)) {
				System.out.printf("%s: %s\n", prefix, s.toString());
			}
		}
	}

	private static void printStudentsSatisfying(Set<Student> students, String prefix, CheckPerson<Student> checker) {
		for (Student s: students) {
			if (checker.check(s)) {
				System.out.printf("%s: %s\n", prefix, s.toString());
			}
		}
	}

	private static void printStudentsAgeBetween(Set<Student> students, int ageLow, int ageHigh) {
		for (Student s: students) {
			if (s.getAge() >= ageLow && s.getAge() <= ageHigh) {
				System.out.printf("Student (age between %d and %d): %s\n", ageLow, ageHigh, s.toString());
			}
		}
	}

	private static void printStudentsOlderThan(Set<Student> students, int age) {
		for (Student s: students) {
			if (s.getAge() > age) {
				System.out.println("Student (age > 30): " + s);
			}
		}
	}

}
