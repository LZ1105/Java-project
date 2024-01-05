package course.nested_classes;

public class Student {
	
	public static class Address {
		private String street;
		private String city;
		private String province;
		private String postalCode;
		
		public Address() {}

		public Address(String street, String city, String province, String postalCode) {
			this.street = street;
			this.city = city;
			this.province = province;
			this.postalCode = postalCode;
		}
		
		@Override
		public Address clone() throws CloneNotSupportedException {
			return new Address(
					this.street, 
					this.city, 
					this.province, 
					this.postalCode);
		}

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getProvince() {
			return province;
		}

		public void setProvince(String province) {
			this.province = province;
		}

		public String getPostalCode() {
			return postalCode;
		}

		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}
		

		@Override
		public String toString() {
			return "Address [street=" + street + ", city=" + city + ", province=" + province + ", postalCode=" + postalCode
					+ "]";
		}
	}
	
	// instance variables
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private Address address;
	
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
	
	public Student(String firstName, String lastName, int age, String gender, Address address) {
		this(firstName, lastName, age, gender);
		this.address = address;
	}

	@Override
	public Student clone() throws CloneNotSupportedException {
		// -------- shallow copy ----------
		Student s = new Student();
		s.firstName = this.firstName;
		s.lastName = this.lastName;
		s.age = this.age;
		s.gender = this.gender;
		s.address = this.address;
		
		// ---------- deep copy ------------
//		return new Student(firstName, lastName, age, gender, 
//				new Address(this.address.getStreet(), this.address.getCity(), 
//						this.address.getProvince(), this.address.getPostalCode()));
//		Student s = new Student();
//		s.firstName = this.firstName;
//		s.lastName = this.lastName;
//		s.age = this.age;
//		s.gender = this.gender;
//		s.address = this.address.clone();
////		s.address = new Address();
////		s.address.setStreet(this.address.getStreet());
////		s.address.setCity(this.address.getCity());
////		s.address.setProvince(this.address.getProvince());
////		s.address.setPostalCode(this.address.getPostalCode());
////		s.address.setPhone(this.address.getPhone());
		return s;
	}
	
	@Override
	public int hashCode() {
		int hash = 7;
	    hash = 31 * hash + age;
	    hash = 31 * hash + firstName.hashCode();
	    hash = 31 * hash + lastName.hashCode();
	    hash = 31 * hash + gender.hashCode();
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
				this.age == anotherStudent.age &&
				this.gender.equals(anotherStudent.gender);
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
