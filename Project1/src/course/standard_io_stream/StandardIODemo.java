package course.standard_io_stream;

import java.util.Scanner;

public class StandardIODemo {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Please input the nominator: ");
		int a = scanner.nextInt();
		
		System.out.print("Please input the denominator: ");
		int b = scanner.nextInt();
		
		div(a, b);
		
		scanner.close();
		
		for (int i = 0; i < 100; i ++) {
			System.out.println("Hello, I'm printing this line to STDOUT - " + i);
		}

		for (int i = 0; i < 100; i ++) {
			System.err.println("Hello, I'm printing this line to STDERR - " + i);
		}
	}

	private static void div(int a, int b) {
		if (b == 0) {
			System.err.println("Denominator (" + b + ") cannot be zero.");
		} else {
			int c = a / b;
			System.out.println(a + " / " + b + " = " + c);
		}
	}

}
