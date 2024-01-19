package course.performance_evaluation;

import java.util.Arrays;

public class SortingProgram {

	public static void main(String[] args) {
		
		int array[] = new int[] {10, 20, 3, 60, 35, 59};

		bubbleSort(array);
		System.out.println("result = " + Arrays.toString(array));
		
		array = new int[] {10, 20, 3, 60, 35, 59};
		selectionSort(array);
		System.out.println("result = " + Arrays.toString(array));

		array = new int[] {10, 20, 3, 60, 35, 59};
		insertionSort(array);
		System.out.println("result = " + Arrays.toString(array));

		array = new int[] {10, 20, 3, 60, 35, 59};
		mergeSort(array);
		System.out.println("result = " + Arrays.toString(array));

		array = new int[] {10, 20, 3, 60, 35, 59};
		quickSort(array);
		System.out.println("result = " + Arrays.toString(array));
	}
	
	private static void quickSort(int[] array) {
		
		throw new RuntimeException("Not implemented yet.");
		
	}

	// Divide and Conquer
	private static void mergeSort(int[] array) {
		if (array.length < 2) {
			return;
		} else if (array.length == 2) {
			if (array[0] > array[1]) {
				int temp = array[1];
				array[1] = array[0];
				array[0] = temp;
			}
			return;
		}
		// divide
		int midPos = array.length / 2;
		int leftSubArray[] = new int[midPos];
		for (int i = 0; i < midPos; i++) {
			leftSubArray[i] = array[i];
		}
		int rightSubArray[] = new int[array.length - midPos];
		for (int i = midPos; i < array.length; i++) {
			rightSubArray[i - midPos] = array[i];
		}

		mergeSort(leftSubArray);
		mergeSort(rightSubArray);
		
		// merge
		// leftSubArray is sorted, rightSubArray is sorted
		int i = 0;
		int j = 0;
		int index = 0;
		while (i < leftSubArray.length && j < rightSubArray.length) {
			if (leftSubArray[i] < rightSubArray[j]) {
				array[index++] = leftSubArray[i++];
			} else {
				array[index++] = rightSubArray[j++];
			}
		}
		if (i < leftSubArray.length) {
			for (int k = i; k < leftSubArray.length; k++) {
				array[index++] = leftSubArray[k];
			}
		} else if (j < rightSubArray.length) {
			for (int k = j; k < rightSubArray.length; k++) {
				array[index++] = rightSubArray[k];
			}
		}
	}

	private static void insertionSort(int[] array) {
		int i = 1;
		while (i < array.length) {
			int x = array[i];
			int j = i;
			while (j > 0 && x < array[j - 1]) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = x;
			i++;
		}
	}

	private static void selectionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		
	}

	// O(1)
	private static void function0(int n ) {
		n ++;
	}

	// O(1)
	// Returns: (n + 10) / 2
	private static int function1(int n) {
		int x = n;
		x = (x + 10) / 2;
		return x;
	}
	
	// O(n)
	// Assume: a.length = n
	private static int max(int a[]) {
		
//		int result = Integer.MIN_VALUE; // O(1)
//		for (int i = 0; i < a.length; i++) { // O(n) = O(n) * O(1)
//			if (result < a[i])
//				result = a[i]; // O(2) = O(1)
//		}
//		return result; // O(1)
		
		int result = a[0]; // O(1)
		for (int i = 1; i < a.length; i++) { // O(n) = O(n-1) * O(1) = O(n-1) = O(n)
			if (result < a[i])
				result = a[i]; // O(2) = O(1)
		}
		return result; // O(1)
	}
	
	// O(n^2)
	private static void bubbleSort(int a[]) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					// swap a[i] and a[j]
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}
	
	// O(n^2)
	private static void function2(int a[]) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				sum += a[i] + a[j];
			}
		}
	}
	
}
