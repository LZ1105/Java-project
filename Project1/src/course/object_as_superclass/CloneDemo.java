package course.object_as_superclass;

public class CloneDemo {

	public static void main(String[] args) {
		Phone phone1 = new Phone("1", "416", "1234567", "321");
		Address addr1 = new Address("100 Yonge st.", "Toronto", "Ontario", "M1A 2B3", phone1);
		Student s1 = new Student("John", "Smith", 30, "M", addr1);
//		System.out.println("s1 = " + s1 + ", hashCode = " + s1.hashCode());
//		addr1.setStreet("200 Yonge st.");
////		s1.getAddress().setStreet("300 Yonge st.");
//		System.out.println("s1 = " + s1 + ", hashCode = " + s1.hashCode());

		try {
			Student s2 = s1.clone();
			System.out.println("s1 = " + s1 + ", hashCode = " + s1.hashCode());
			System.out.println("s2 = " + s2 + ", hashCode = " + s2.hashCode());
			addr1.setStreet("200 Yonge st.");
//			s1.setAddress(new Address("150 Yonge st.", "Toronto", "Ontario", "M1A 2B3", phone1));
			s1.getAddress().getPhone().setLocalNumber("7654321");
			s1.setFirstName("Mary");
			System.out.println("s1 = " + s1 + ", hashCode = " + s1.hashCode());
			System.out.println("s2 = " + s2 + ", hashCode = " + s2.hashCode());
		} catch (CloneNotSupportedException e) {
			System.out.println("Error in cloning student object.");
			e.printStackTrace();
		}

	}

}
