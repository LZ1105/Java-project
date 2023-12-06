package Lucas1;

public class ClasLucas {

	public static void main(String[] args) {
		System.out.println("Hello World."); // print greeting
/*
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
*/
//question 1
		int height;
		height = 10; 
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			
			for (int j = 0; j < height; j++) {
				System.out.print("#");
			}
			System.out.println();
		}


//question 2

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height - i - 1; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < height; j++) {
                System.out.print("#");
            }

            System.out.println();
        }
        
//question 3
        
        int n = 9; 

        for (int i = 1; i <= n; i += 2) {
            for (int j = 0; j < (n - i) / 2; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }


        for (int i = n - 2; i >= 1; i -= 2) {
            for (int j = 0; j < (n - i) / 2; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i; k++) {
                System.out.print("*");
            }
            System.out.println();
        
        	
        
    }
	}

//question 4
/*		int n =9;
	    for (int i = 1; i <= n; i += 2) {
	        for (int j = 0; j < (n - i) / 2; j++) {
	            System.out.print(" ");
	        }
	        for (int k = 0; k < i; k++) {
	            System.out.print("*");
	        }
	        System.out.println();
	    }
	
	    for (int i = 1; i <= n; i += 2) {
	        for (int j = 0; j < i / 2; j++) {
	            System.out.print(" ");
	        }
	        for (int k = i; k < n; k++) {
	            System.out.print("*");
	        }
	        System.out.println();
	    }
	}
*/
//question 5
/*	int num = 5;
			int denom = 7;

		    int result = num / denom;

		    if ((num < 0) != (denom < 0) && num % denom != 0) {
		        result += (num > 0) ? 1 : -1;
		    }
		    return result;
		    }
		    }
		
		}
*/
//insertion sort
	    public static void insertionSort(int[] arr) {
	        int n = arr.length;

	        for (int i = 1; i < n; ++i) {
	            int key = arr[i];
	            int j = i - 1;

	            while (j >= 0 && arr[j] > key) {
	                arr[j + 1] = arr[j];
	                j = j - 1;
	            }
	            arr[j + 1] = key;
	        }
	    }

	    public static void printArray(int[] arr) {
	        for (int num : arr) {
	            System.out.print(num + " ");
	        }
	        System.out.println();
	    }

	    }
	   
				
			
			


		
		
				