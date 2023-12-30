package course.collections;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

	public static void main(String[] args) {
		
		Map<Integer, Student> students = new HashMap<>();
		Student s1 = new Student("John", "Smith", 30);
		students.put(1, s1);
		students.put(2, new Student("Mary", "Poppins", 32));
		students.put(3, new Student("Alice", "Green", 33));
		students.put(4, s1);
		students.put(5, new Student("Alice", "Green", 33));
		
		students.get(1).setAge(60);
		students.get(5).setAge(70);

		System.out.println("Student (id = 2): " + students.get(2));
		
		System.out.println("Iterating map #1");
		for (Integer key : students.keySet()) {
			System.out.printf("Student (%d): %s\n", key, students.get(key));
		}
		
		System.out.println("Iterating map #2");
		for (Student stu : students.values()) {
			System.out.printf("Student : %s\n", stu);
		}
		
		students.put(5, new Student("Bob", "Pack", 90));

		System.out.println("Iterating map #3");
		for (Map.Entry<Integer, Student> entry : students.entrySet()) {
			System.out.printf("Student (%d): %s\n", entry.getKey(), entry.getValue());
		}
	}

}
