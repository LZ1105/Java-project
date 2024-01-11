package course.nested_classes.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class StreamsDemo {
	
	static class Stat {
		int total;
	}

	public static void main(String[] args) {
		List<Student> students = new LinkedList<>();
		students.add(new Student("John", "Smith", 30, "M"));
		students.add(new Student("Mary", "Poppins", 32, "F"));
		students.add(new Student("John", "Brown", 33, "M"));
		students.add(new Student("Steve", "Green", 21, "M"));
		students.add(new Student("Alice", "Smith", 33, "F"));
		
//		int total = 0;
		Stat stat = new Stat();
		
		int total = 
		(int) students.stream()
			.filter(s -> s.getAge() > 25)
			.map(s -> s.getFirstName() + " " + s.getLastName())
			.count();
//			.forEach( name -> stat.total++);
//			.forEach( System.out::println);
		
		System.out.println("total = " + total);
		System.out.println("total = " + stat.total);
		
		students.stream()
		.filter(s -> s.getAge() > 25)
		.map(s -> {s.setAge(s.getAge() + 1); return s;})
		.forEach( System.out::println);
		
		List<Integer> numbers = Arrays.asList(33, 20, 29, 120, 15, 51);
		int result = numbers.stream().reduce(0, (a, b) -> a + b);
		System.out.println("sum: " + result);

		// 33, 20, 29, 120, 15, 51
		// 15, 33, 20, 29, 120, 51
		// 15, 20, 33, 29, 120, 51
		// 15, 20, 29, 33, 120, 51
		// 15, 20, 29, 33, 51, 120
		// O(n^2)
//		for (int i = 0; i < numbers.size() - 1; i++) {
//			for (int j = i; j < numbers.size(); j++) {
//				if (numbers.get(i) > numbers.get(j)) {
//					// swap numbers[i] and numbers[j]
//					int temp = numbers.get(i);
//					numbers.set(i, numbers.get(j));
//					numbers.set(j,  temp);
//				}
//			}
//		}
		
		
		Collections.sort(numbers); // O(nlogn)
		System.out.println("Sorted numbers = " + numbers);
		
		Collections.sort(students);
		System.out.println("Sorted by age: students = " + students);
		
		Collections.sort(students, new StudentNameComparator());
		System.out.println("Sorted by name: students = " + students);
		
		Collections.sort(students, (s1, s2) -> s1.getGender().compareTo(s2.getGender()));
		System.out.println("Sorted by gender: students = " + students);
		

	}

}

