package course.object_as_superclass;

public class GCDemo {

	public static void main(String[] args) {
		Student s1 = 
				new Student(
						"John", 
						"Smith", 
						30, 
						"M", 
						new Address(
								"100 Yonge st.", 
								"Toronto", 
								"Ontario", 
								"M1A 2B3", 
								new Phone(
										"1", 
										"416", 
										"1234567", 
										"321")));
		System.out.println("s1 = " + s1);
		s1.getAddress().setPhone(new Phone("1", "905", "1234567", null));
		System.out.println("s1 = " + s1);
		for (int i = 0; i < 100; i++) {
			s1.setAddress(new Address("200 Main st.", "Markham", "Ontario", "L1B 2C3", new Phone("", "647", "1234567", "")));
//			System.gc();
			System.out.println(Runtime.getRuntime().freeMemory());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}
		System.out.println("s1 = " + s1);
		
	}

}
