package course.strings;

import java.util.Arrays;

public class CharacterDemo {

	public static void main(String[] args) {
		
		char chs[] = "good morning".toCharArray();
		System.out.println("Before: chs = " + Arrays.toString(chs));
		toUpperCase2(chs);
		System.out.println("After: chs = " + Arrays.toString(chs));

	}

	// only works for ASCII encoding
	private static void toUpperCase(char[] chs) {
		for (int i = 0; i < chs.length; i++) {
			if (chs[i] >= 'a' && chs[i] <= 'z') {
				chs[i] -= ('a' - 'A');
			}
		}
		System.out.println("chs = " + Arrays.toString(chs));
	}
	
	// works for Unicode encoding
	private static void toUpperCase2(char[] chs) {
		for (int i = 0; i < chs.length; i++) {
			if (Character.isLetter(chs[i])) {
				chs[i] = Character.toUpperCase(chs[i]);
			}
		}
		System.out.println("chs = " + Arrays.toString(chs));
	}

}
