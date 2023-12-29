package course.collections;

import java.util.Arrays;

public class BetterSorter implements Sorter {

	@Override
	public void sort(int[] array) {
		Arrays.sort(array);
	}

	@Override
	public void sort(String[] array) {
		Arrays.sort(array);
	}

}
