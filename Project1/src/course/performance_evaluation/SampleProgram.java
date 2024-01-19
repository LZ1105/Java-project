package course.performance_evaluation;

import java.util.Arrays;

public class SampleProgram {

	public static void main(String[] args) {
		
		function1(10);
		
		int array[] = new int[] {10, 20, 3, 60, 35, 59};
		bubbleSort(array);
		System.out.println("result = " + Arrays.toString(array));

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
