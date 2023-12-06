package course.sorting;

public class Sorting {

	public static void main(String[] args) {
		
		int data[] = {1, 30, 22, 9, 21, 33, 10, 200, 39, 72, 2};
		
		printArray(data);
		
		sort1(data);
		
		printArray(data);
		

	}

	private static void printArray(int[] data) {
		for (int d : data) {
			System.out.print(d + " ");
		}
		System.out.println();
	}

	private static void sort1(int[] data) {
		
		// i = 0..n-2, for each ai
		//   j = (i+1)..(n-1), for each aj
		//       compare ai with aj, and swap if ai > aj
		
		for (int i = 0; i < data.length - 1; i++ ) {
			for (int j = i + 1; j < data.length; j ++) {
				if (data[i] >  data[j]) {
					// swap data[i] with data[j], if data[i] > data[j]
					int temp = data[i];
					data[i] = data[j];
					data[j] = temp;
				}
			}
		}
		
	}

}
