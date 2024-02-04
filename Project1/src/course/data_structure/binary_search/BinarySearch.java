package course.data_structure.binary_search;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		
		int array[] = {20, 30, 90, 60, 12, 31, 66, 21, 19, 3, 100, 70};
		int index = linearSearch(array, 31); // O(n)
		if (index >= 0) {
			System.out.println("Found: array[" + index + "] = " + array[index]);
		} else {
			System.out.println("Not found!");
		}
		
		int array2[] = array.clone();
		Arrays.sort(array2); // O(nlogn)
		System.out.println("array2 = " + Arrays.toString(array2)); 
		
		index = binarySearch(array2, 90, 0, array2.length); // O(logn)
		if (index >= 0) {
			System.out.println("Found: array2[" + index + "] = " + array2[index]);
		} else {
			System.out.println("Not found!");
		}
		
	}

	private static int binarySearch(int[] array, int num, int lo, int hi) {
		int mid = (hi - lo) / 2 + lo;
		if (array[mid] == num) {
			return mid;
		} else if (lo >= hi) {
			return -1; // not found
		} else if (num < array[mid]) {
			return binarySearch(array, num, lo, mid - 1);
		} else { // num > array[mid];
			return binarySearch(array, num, mid + 1, hi);
		}
	}

	// O(n)
	private static int linearSearch(int[] array, int num) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == num) {
				return i;
			}
		}
		return -1;
	}

}
