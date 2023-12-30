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
	}

}
