package course.object_as_superclass;

public class GiftedStudent extends Student {
	
	@Override
	public Address getAddress() {
		return super.getAddress();
	}

}
