package course.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListDemo {

	public static void main(String[] args) {
		
		List<String> sentences = new ArrayList<>();
		sentences.add("hello");
		sentences.add("good");
		sentences.add("morning");
		sentences.add("good");
		sentences.add("evening");
		
		System.out.println("set's size = " + sentences.size());
		
		for (Object s : sentences) {
			System.out.println("Sentence: " + s);
		}
		
		for (int i = 0; i < sentences.size(); i++) {
			System.out.println("Sentence(2): " + sentences.get(i));
		}
		
		System.out.println("Does sentences contain \"good\"? " + sentences.contains("good"));
//		sentences.remove("good");
//		sentences.remove(1);
		System.out.println("After removing, set's size = " + sentences.size());
		Iterator<String> it = sentences.iterator();
		while (it.hasNext()) {
			System.out.println("sentence: " + it.next());
		}
		
		Collections.sort(sentences);
		System.out.println("------ After sorting ------");
		for (Object s : sentences) {
			System.out.println("Sentence: " + s);
		}
		
		System.out.println("------ Fast fail demo ------");
		// fast-fail
		for (String s : sentences) {
//		for (int i= sentences.size() - 1; i >= 0; i--) {
//			String s = sentences.get(i);
			if ("good".equals(s)) {
				System.out.println("Removing \"" + s + "\" from sentences...");
				sentences.remove(s);
				System.out.println("Removed");
//				i--;
			}
		}
		System.out.println("------ After removing \"good\" ------");
		for (String s : sentences) {
			System.out.println("Sentence: " + s);
		}


	}

}
