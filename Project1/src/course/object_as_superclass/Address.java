package course.object_as_superclass;

public class Address {
	
	private String street;
	private String city;
	private String province;
	private String postalCode;
	private Phone phone;
	
	public Address() {}

	public Address(String street, String city, String province, String postalCode, Phone phone) {
		this.street = street;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
		this.phone = phone;
	}
	
	@Override
	public Address clone() throws CloneNotSupportedException {
		return new Address(
				this.street, 
				this.city, 
				this.province, 
				this.postalCode, 
				this.phone.clone());
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
	
	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", province=" + province + ", postalCode=" + postalCode
				+ ", phone=" + phone + "]";
	}

}
