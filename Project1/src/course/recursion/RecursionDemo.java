package course.recursion;

public class RecursionDemo {

	public static void main(String[] args) {
		
		int r = addToN_usingLoop(100);
		System.out.println("r = " + r);
		
		r = addToN_usingRecursion(100);
		System.out.println("r = " + r);


	}

	// returns 1 + 2 + ... + n
	// 1 + 2 + ... n             =   (1 + 2 + ... (n-1))        + n = [(1 + 2 + ... (n-2))       + (n-1)] + n
	// addToN_usingRecursion(n)      addToN_usingRecursion(n-1) + n = addToN_usingRecursion(n-2)     
	//                                                                     addToN_usingRecursion(n-1)     + n
	// f(n) = 
	//     1    		; n =1 (base condition / base case)
	//     n + f(n-1)	; n > 1 (recursion definition)
	private static int addToN_usingRecursion(int n) {
		// base case
		if (n <= 1) {
			return 1;
		}
		// recursion
		return n + addToN_usingRecursion(n - 1);
		
	}

	private static int addToN_usingLoop(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		return sum;
	}

}
