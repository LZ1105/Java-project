package course.interfaces;

import java.io.Serializable;

public class InterfaceDemo {

	public static void main(String[] args) {
		DoIt doIt = new MyDoIt();
		doIt.func1(10);
		doIt.func2("Hello");
		doIt.func3(100, "Dollars");
		System.out.println("Interface: " + DoIt.typeName());
		
		Serializable obj1 = new Car();
		Serializable obj2 = new Student();
		Serializable obj3 = new Fruit();
		
		Car car1 = new HybridCar("Toyota", "Camry", 6.1, 100);
		
		NewEnergyCar car2 = new HybridCar("Toyota", "Camry", 6.1, 100);

		car1.getBrand();
		car2.getEmissionRatio();
		
		NewEnergyCar cars[] = new NewEnergyCar[] {
				new HybridCar("Toyota", "Camry", 6.1, 100),
				new ElectricalCar("Tesla", "Model 3", 630),
				new HybridCar("Lexus", "RX450", 7.3, 160)
		};
		
		generateReport(cars);
		
		SubClass sb = new SubClass();
		
	}

	private static void generateReport(NewEnergyCar...cars) {
		
		System.out.println("============ New Energy Car ============");
		System.out.println("\tName\t\tEmission Ratio");
		for (NewEnergyCar car : cars) {
			// This is sort of complicated, and has one disadvantage: what if we have a new class (that implements the NewEnergyCar)?
//			String name = "";
//			if (car instanceof HybridCar) {
//				name = ((HybridCar)car).getBrand() + " - " + ((HybridCar)car).getModel();
//			} else if (car instanceof ElectricalCar) {
//				name = ((ElectricalCar)car).getBrand() + " - " + ((ElectricalCar)car).getModel();
//			}
//			System.out.printf("\t%s\t\t%6.2f%n", name, car.getEmissionRatio());
			System.out.printf("\t%s\t\t%6.2f%n", car.getName(), car.getEmissionRatio());
		}
		
	}
	
	

}
