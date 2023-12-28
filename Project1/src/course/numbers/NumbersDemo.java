package course.numbers;

import static java.lang.Math.abs;

public class NumbersDemo {

	public static void main(String[] args) {
		String s1 = "123456789"; // "123" vs 123
		String s2 = "987654321";
		
		int num1 = Integer.parseInt(s1);
		int num2 = Integer.parseInt(s2);
		
		int r = num1 + num2;
//		System.out.printf("r = %020d\n", r);
		String output = String.format("r = %020d\n", r);
		System.out.println(output);
		
		Integer numObj1 = new Integer(num1);
		Integer numObj2 = Integer.valueOf(num2);
		Integer numObj3 = num1; // auto-boxing
		
		int r2 = abs(r);
	

	}

}
