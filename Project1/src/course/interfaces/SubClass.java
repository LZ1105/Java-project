package course.interfaces;

public class SubClass extends SuperClass {
	
	@Override
	public HybridCar doSomething(Car car) {
		return null;
	}

	// Without @Override, the compiler will not complain the following method.
	// However, you actually defined a new method, which is an overloading of doSomething() method (because you have inherited the doSomething(Car) from the SuperClass.
//	@Override
	public HybridCar doSomething(HybridCar car) {
		return null;
	}
}
