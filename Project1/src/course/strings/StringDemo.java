package course.strings;

public class StringDemo {

	public static void main(String[] args) {
		
		String s1 = "Hello, Lukas. How are you doing? I know your name is Lukas. I knew another person who has the same name Lukas.";
		String name = "John";
		String s2 = replaceName2(s1, "Lukas", name);
		System.out.println(s2);
		
		char characters[] = "Hello".toCharArray();
		characters[1] = 'a';
//		String s3 = new String(characters);
		String s3 = String.copyValueOf(characters, 1, 3);
		System.out.println("s3 = " + s3);
		
		String s4 = replaceName(s1.toCharArray(), "Lukas", name);
		System.out.println(s4);

	}

	// assignment
	private static String replaceName(char[] charArray, String oldName, String newName) {
		// TODO Auto-generated method stub
		return null;
	}

	// version #1: Using string concatenation. Bad performance
	private static String replaceName(String sentence, String oldName, String newName) {
		
		int pos = sentence.indexOf(oldName);
		
		while(pos >= 0) {
			sentence = sentence.substring(0, pos) + newName + sentence.substring(pos + oldName.length());
			// "Hello, John. How are you doing? I know your name is Lukas. I knew another person who has the same name Lukas.";
			// "Hello, John. How are you doing? I know your name is John. I knew another person who has the same name Lukas.";
			// "Hello, John. How are you doing? I know your name is John. I knew another person who has the same name John.";
			pos = sentence.indexOf(oldName, pos + 1);
		}
		return sentence;
		
	}
	
	// version #2: Using StringBuffer. Good performance
	// StringBuffer: thread-safe
	// StringBuilder: faster, but not thread-safe
	private static String replaceName2(String sentence, String oldName, String newName) {
			
//			String result = "";
			StringBuffer result = new StringBuffer("");
			int pos = sentence.indexOf(oldName);
			int pos0 = 0;
			while(pos >= 0) {
				result.append(sentence.substring(pos0, pos) + newName);
				pos0 = pos + oldName.length();
				pos = sentence.indexOf(oldName, pos0);
			}
			result.append(sentence.substring(pos0));
			return result.toString();

		}

}
