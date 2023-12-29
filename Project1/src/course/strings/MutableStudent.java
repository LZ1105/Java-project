package course.strings;

public class MutableStudent {
	
	// instance variables
	private String firstName;
	private String lastName;
	private int age;
	
	// default constructor
	public MutableStudent() {
		System.out.println("A new student object is created.");
		age = 10;
	}
	
	public MutableStudent(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	// getter or accessor
	public String getFirstName() {
		return firstName;
	}
	
	// setter or modifier
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age +  "]";
	}

}
