package course.nested_classes;

import java.util.ArrayList;
import java.util.List;

public class DataProcessor {
	
	public static List<Integer> filterData(List<Integer> data, DataChecker checker) {
		List<Integer> result = new ArrayList<>();
		for (Integer dataEntry : data) {
			if (checker.isGoodData(dataEntry)) {
				result.add(dataEntry);
			}
		}
		return result;
	}

}
