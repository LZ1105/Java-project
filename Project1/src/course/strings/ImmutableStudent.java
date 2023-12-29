package course.strings;

public class ImmutableStudent {
	
	// instance variables
	private String firstName;
	private String lastName;
	private int age;
	
	// default constructor
	public ImmutableStudent() {
		System.out.println("A new student object is created.");
		age = 10;
	}
	
	public ImmutableStudent(String firstName, String lastName, int age) {
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
	public ImmutableStudent setFirstName(String firstName) {
		ImmutableStudent s = new ImmutableStudent(firstName, this.lastName, this.age);
		return s;
	}
	
	public String getLastName() {
		return firstName;
	}
	
	public ImmutableStudent setLastName(String lastName) {
		return new ImmutableStudent(this.firstName, lastName, this.age);
	}

	public int getAge() {
		return age;
	}

	public ImmutableStudent setAge(int age) {
		return new ImmutableStudent(this.firstName, this.lastName, age);
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age +  "]";
	}

}
