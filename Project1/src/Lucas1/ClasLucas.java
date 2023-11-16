package Lucas1;

public class ClasLucas {

	public static void main(String[] args) {
		System.out.println("Hello World."); // print greeting.

		// vairable declarations
		int a = 10;
		int b;
		b = 20;
		int c;
		long ll = 321;
		short d = 0x3A;
		char ch = '\n';
		String s = "good\tmorning\nHow are you";
		double num1 = 123.321;
		float num2 = 123.321f;
		num1 = num2;
		num2 = (float) num1;
		ll = a;
		a = (int) ll;

		c = a + b; // assignment statement: assign the value of the expression on the right of "="
					// to the variable on the left of "="
		// 10 + 20 = 30
		System.out.println(a + " + " + b + " = " + c);
		System.out.println("d = " + d);
		System.out.println("s = " + s);

	}

}