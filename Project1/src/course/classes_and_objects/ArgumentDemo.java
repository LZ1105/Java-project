package course.classes_and_objects;

public class ArgumentDemo {

	public static void main(String[] args) {
		
		System.out.println("Hello");
		System.out.println("Argument count: " + args.length);
		for (int i = 0; i < args.length; i++) {
			System.out.println("Argument #" + (i+1) + " = " + args[i]);
		}

	}

}
