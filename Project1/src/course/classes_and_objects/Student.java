package course.classes_and_objects;

public class Student {
	
	// instance variables
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	
	// default constructor
	public Student() {
		System.out.println("A new student object is created.");
		age = 10;
	}
	
	public Student(String firstName, String lastName, int age, String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
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
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	void print() {
		System.out.println("Student: name = " + firstName + " " + lastName + ", age = " + age + ", gender = " + gender);
	}
	

}
