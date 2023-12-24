package course.interfaces;

public class ElectricalCar extends Car implements NewEnergyCar {
	
	private double distancePerFullCharge;
	
	public ElectricalCar() {}

	public ElectricalCar(String brand, String model, double distancePerFullCharge) {
		super(brand, model);
		this.distancePerFullCharge = distancePerFullCharge;
	}

	public double getDistancePerFullCharge() {
		return distancePerFullCharge;
	}

	public void setDistancePerFullCharge(double distancePerFullCharge) {
		this.distancePerFullCharge = distancePerFullCharge;
	}

	@Override
	public double getEmissionRatio() {
		return distancePerFullCharge * 1.2;
	}

	@Override
	public String getName() {
		return this.getBrand() + " - " + this.getModel() + "[E]";
	}

	
}
