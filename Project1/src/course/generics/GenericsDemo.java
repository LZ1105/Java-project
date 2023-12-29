package course.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {

	public static void main(String[] args) {
		
		List<Integer> myList = new ArrayList<>();
		myList.add(10);
		myList.add(20);
		myList.add(30);
		
		int r = sum(myList);
		System.out.println("r = " + r);

	}

	private static int sum(List<Integer> myList) {
		int total = 0;
		for (int i = 0; i < myList.size(); i++) {
			total += myList.get(i);
		}
		return total;
	}

}
