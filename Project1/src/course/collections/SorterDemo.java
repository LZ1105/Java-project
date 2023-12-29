package course.collections;

import java.util.Arrays;

public class SorterDemo {

	public static void main(String[] args) {
		
		int a[] = {1, 3, 9, 6, 2, 10};
		Sorter sorter = new BetterSorter();
		sorter.sort(a);
		System.out.println("Sorted: a = " + Arrays.toString(a));

	}

}
