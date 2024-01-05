package course.nested_classes;

import java.util.Arrays;
import java.util.List;

public class AnonymouseClassDemo {

	public static void main(String[] args) {
		
		List<Integer> data = Arrays.asList(10, 23, -99, 200, 301, -20, 92);
		
		// approach 1: using a local class (or inner class or regular class)
		class EvenDataFilter implements DataChecker {
			@Override
			public boolean isGoodData(int data) {
				return data % 2 == 0;
			}
		}
		List<Integer> result = DataProcessor.filterData(data, new EvenDataFilter());
		System.out.println("result = " + result);

		// Below is the same as above, just we introduce an extra variable, evenDataFilter
		DataChecker evenDataFilter = new EvenDataFilter();
		result = DataProcessor.filterData(data, evenDataFilter);

		// approach 2: using anonymous inner class.
		result = DataProcessor.filterData(data, new DataChecker() {
			@Override
			public boolean isGoodData(int data) {
				return data >= 0;
			}
		});
		System.out.println("result = " + result);

		result = DataProcessor.filterData(data, new DataChecker() {
			@Override
			public boolean isGoodData(int data) {
				return data %2 != 0;
			}
		});
		System.out.println("result = " + result);

	
		// Below is the same as above, just we introduce an extra variable, oddDataChecker
		DataChecker oddDataChecker = new DataChecker() {
			@Override
			public boolean isGoodData(int data) {
				return data %2 != 0;
			}
		};
		DataProcessor.filterData(data, oddDataChecker);
		System.out.println("result = " + result);
		
//		int a1 = 10;
//		int a2 = 20;
//		int b = 30;
//		int a = a1 + a2;
//		int r = add(a, a1 + a2);
		
		
	}
	
	private static int add(int a, int b) {
		return a + b;
	}

}
