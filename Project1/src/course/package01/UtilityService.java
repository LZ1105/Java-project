package course.package01;

import course.classes_and_objects.Student;

public class UtilityService {
	
	private static int add(int a, int b) {
		int c;
		c = a + b;
		return c;
	}

	public static void main(String[] args) {
		System.out.println("Hello World."); // print greeting.
		
		int r = add(10, 20);
		System.out.println("r = " + r);
//		
//		func01();
		
//		func02();
		
		drawParallelogram(10, '*');
		
	
	}

	private static void drawParallelogram(int height, char c) {
	}

	private static void func02() {
		int grade1 = 93;
		int grade2 = 89;
//		int[] grade = new int[10];
		int grade[] = {10, 20, 33, 40, -50, 69, 71, 80, -90, 100};
		
		
		int sum = 0;
//		for (int i = 0; i < 10; i++) {
//			sum += grade[i];
//		}
		for (int g : grade) {
			sum += g;
		}
		System.out.println("sum = " + sum);
		
		boolean hasInvalidGrade = false;
		
		for (int g : grade) {
			if (g < 0) {
				hasInvalidGrade = true;
				break;
			}
		}
		System.out.println("Has invalid grade? " + hasInvalidGrade);
		
		int score = 96;
		char myGrade = 'C';
		
		for (int i = 0; i < 10; i++) {
			if (grade[i] % 2 != 0) {
				continue;
			}
			System.out.println("Grade: " + grade[i]);
		}
		
//		if (score >= 90) {
//			myGrade = 'A';
//		} else if (score >= 80) {
//			myGrade = 'B';
//		}
	
		if (score >= 90) {
			myGrade = 'A';
		}
		
		if (score < 90 && score >= 80) {
			myGrade = 'B';
		}
		System.out.println("myGrade = " + myGrade);		
	}

	private static void func01() {
		// vairable declarations
		int a = 10;
		int b;
		b = 20;
		int c;
		long ll = 3219999999L;
		short d = 0x3A;
		char ch = '\n';
		String s = "good\tmorning\nHow are you";
		double num1 = 123.321;
		float num2 = 123.321f;
		num1 = num2;
		num2 = (float) num1;
//		ll = a;
		a = (int) ll;
		
		System.out.println("a = " + a);
//		ll = a;
		
		c = a + b; // assignment statement: assign the value of the expression on the right of "=" to the variable on the left of "="
		// 10 + 20 = 30
		System.out.println(a + " + " + b + " = " + c);
		System.out.println("d = " + d);
		System.out.println("s = " + s);	
	}

}
