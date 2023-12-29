package course.collections;

public class Student {
	
	// instance variables
	private String firstName;
	private String lastName;
	private int age;
	
	// default constructor
	public Student() {
		System.out.println("A new student object is created.");
		age = 10;
	}
	
	public Student(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	@Override
	public int hashCode() {
		int hash = 7;
	    hash = 31 * hash + age;
	    hash = 31 * hash + firstName.hashCode();
	    hash = 31 * hash + lastName.hashCode();
	    return hash;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj instanceof Student) {
			Student anotherStudent = (Student) obj;
			return this.firstName.equals(anotherStudent.firstName) &&
				this.lastName.equals(anotherStudent.lastName) &&
				this.age == anotherStudent.age;
		} else {
			return false;
		}
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
