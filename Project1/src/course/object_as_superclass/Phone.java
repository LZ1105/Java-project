package course.object_as_superclass;

public class Phone {
	private String countryCode;
	private String areaCode;
	private String localNumber;
	private String extension;
	private long dumpData[] = new long[102400000];
	
	public Phone() {}
	
	public Phone(String countryCode, String areaCode, String localNumber, String extension) {
		super();
		this.countryCode = countryCode;
		this.areaCode = areaCode;
		this.localNumber = localNumber;
		this.extension = extension;
	}
	
	@Override
	public Phone clone() throws CloneNotSupportedException {
		return new Phone(
				this.countryCode, 
				this.areaCode, 
				this.localNumber, 
				this.extension);
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Phone object is GC collected.");
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getLocalNumber() {
		return localNumber;
	}

	public void setLocalNumber(String localNumber) {
		this.localNumber = localNumber;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	@Override
	public String toString() {
		String phoneStr = this.countryCode == null || this.countryCode.trim().length() == 0 ? "" : this.countryCode + "-";
		phoneStr += this.areaCode + "-" + this.localNumber;
		if (this.extension != null && this.extension.trim().length() > 0) {
			phoneStr += "x" + this.extension;
		}
		return phoneStr;
	}

}
