package course.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo {

	public static void main(String[] args) {
		
		Set sentences = new HashSet();
		boolean r = sentences.add("hello");
		if (r) { System.out.println("hello added."); }
		r = sentences.add("good");
		if (r) { System.out.println("good added."); }
		r = sentences.add("morning");
		if (r) { System.out.println("morning added."); }
		r = sentences.add("good");
		if (r) { System.out.println("good added."); }
		r = sentences.add("evening");
		if (r) { System.out.println("evening added."); }
		
		System.out.println("set's size = " + sentences.size());
		
		for (Object s : sentences) {
			System.out.println("Sentence: " + s);
		}
		
		System.out.println("Does sentences contain \"good\"? " + sentences.contains("good"));
		sentences.remove("good");
		System.out.println("After removing, set's size = " + sentences.size());
		Iterator it = sentences.iterator();
		while (it.hasNext()) {
			System.out.println("sentence: " + it.next());
		}
		
		String s = "The class String includes methods for examining individual characters of the sequence, for comparing strings, for searching strings, for extracting substrings, and for creating a copy of a string with all characters translated to uppercase or to lowercase. Case mapping is based on the Unicode Standard version specified by the Character class.\r\n"
				+ "\r\n"
				+ "The Java language provides special support for the string concatenation operator ( + ), and for conversion of other objects to strings. String concatenation is implemented through the StringBuilder(or StringBuffer) class and its append method. String conversions are implemented through the method toString, defined by Object and inherited by all classes in Java. For additional information on string concatenation and conversion, see Gosling, Joy, and Steele, The Java Language Specification.\r\n"
				+ "\r\n"
				+ "Unless otherwise noted, passing a null argument to a constructor or method in this class will cause a NullPointerException to be thrown.\r\n"
				+ "\r\n"
				+ "A String represents a string in the UTF-16 format in which supplementary characters are represented by surrogate pairs (see the section Unicode Character Representations in the Character class for more information). Index values refer to char code units, so a supplementary character uses two positions in a String.\r\n"
				+ "\r\n"
				+ "The String class provides methods for dealing with Unicode code points (i.e., characters), in addition to those for dealing with Unicode code units (i.e., char values).";
		int count = countUniqueWord(s);
		System.out.println("Unique words: " + count);
		
		Set<Student> students = new HashSet<>();
		students.add(new Student("John", "Smith", 30));
		students.add(new Student("Mary", "Poppins", 32));
		students.add(new Student("John", "Smith", 33));
		
		for (Student stu : students) {
			System.out.println("Student: " + stu);
		}
		
		Set<Student> students2 = new HashSet<>();
		students2.add(new Student("Steve", "Green", 21));
		students2.add(new Student("John", "Smith", 33));

		for (Student stu : students2) {
			System.out.println("Student2: " + stu);
		}
		
//		students.addAll(students2); // students = students union students2
//		students.removeAll(students2); // students = students - (students intersect students2)
//		students.retainAll(students2); // students = students intersect students2
		for (Student stu : students) {
			System.out.println("Student: " + stu);
		}
		

	}

	// returns # of unique word, case-insensitive, ignoring punctuation.
	// hints: (1) remove all punctuation, (2) extract each single word (3) utilize the Set's functions.
	private static int countUniqueWord(String s) {
		// TODO Auto-generated method stub
		return 0;
	}

}
