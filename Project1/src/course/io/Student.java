package course.io;

import java.io.Serializable;

public class Student implements Serializable {
	
	// instance variables
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private Address address;
	
	transient private NetworkConnection conn = new NetworkConnection();
	
	// default constructor
	public Student() {
		age = 10;
	}
	
	public Student(String firstName, String lastName, int age, String gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
	}
	
	public Student(String firstName, String lastName, int age, String gender, Address address) {
		this(firstName, lastName, age, gender);
		this.address = address;
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
		return lastName;
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
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender
				+ ", address=" + address + "]";
	}

}
