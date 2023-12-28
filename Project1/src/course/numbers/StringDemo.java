package course.numbers;

public class StringDemo {

	public static void main(String[] args) {
		
		String s = "The class String includes methods for examining individual characters of the sequence, for comparing strings, for searching strings, for extracting substrings, and for creating a copy of a string with all characters translated to uppercase or to lowercase. Case mapping is based on the Unicode Standard version specified by the Character class.\r\n"
				+ "\r\n"
				+ "The Java language provides special support for the string concatenation operator ( + ), and for conversion of other objects to strings. String concatenation is implemented through the StringBuilder(or StringBuffer) class and its append method. String conversions are implemented through the method toString, defined by Object and inherited by all classes in Java. For additional information on string concatenation and conversion, see Gosling, Joy, and Steele, The Java Language Specification.\r\n"
				+ "\r\n"
				+ "Unless otherwise noted, passing a null argument to a constructor or method in this class will cause a NullPointerException to be thrown.\r\n"
				+ "\r\n"
				+ "A String represents a string in the UTF-16 format in which supplementary characters are represented by surrogate pairs (see the section Unicode Character Representations in the Character class for more information). Index values refer to char code units, so a supplementary character uses two positions in a String.\r\n"
				+ "\r\n"
				+ "The String class provides methods for dealing with Unicode code points (i.e., characters), in addition to those for dealing with Unicode code units (i.e., char values).";
		String sentences[] = extractSentence(s);
		
		s = "There are 5 trucks on Finch Ave with 20 people."
				+ "\r\n"
				+ "There are 20 buses on Sheppard Ave with 100 people."
				+ "\r\n"
				+ "There are 11 cars on Yonge st with 23 people."
				+ "\r\n"
				+ "There are 20 buses on Midland Ave with 123 people."
				+ "\r\n"
				+ "There are 21 buses on Lawrence Ave with 90 people.";
		processInfo(s);

	}

	// print: 
	// 5 trucks - Finch Ave - 20 people
	// 20 buses - Sheppard Ave - 100 people
	// ...
	private static void processInfo(String s) {
		
	}

	// example: paragraph = "Hello. How are you? Let's have fun."
	// output: new String[] {"Hello", "How are you?", "Let's have fun."}
	private static String[] extractSentence(String paragraph) {
		return null;
	}

}
