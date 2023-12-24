package course.interfaces;

public class HybridCar extends Car implements NewEnergyCar {
	
	private double gasConsumption; // per 100 km.
	private double distancePerFullCharge;
	
	public HybridCar() {}

	public HybridCar(String brand, String model, double gasConsumption, double distancePerFullCharge) {
		super(brand, model);
		this.gasConsumption = gasConsumption;
		this.distancePerFullCharge = distancePerFullCharge;
	}

	public double getGasConsumption() {
		return gasConsumption;
	}

	public void setGasConsumption(double gasConsumption) {
		this.gasConsumption = gasConsumption;
	}

	public double getDistancePerFullCharge() {
		return distancePerFullCharge;
	}

	public void setDistancePerFullCharge(double distancePerFullCharge) {
		this.distancePerFullCharge = distancePerFullCharge;
	}

	@Override
	public double getEmissionRatio() {
		// TODO Auto-generated method stub
		return distancePerFullCharge / gasConsumption;
	}

	@Override
	public String getName() {
		return this.getBrand() + " - " + this.getModel() + "[H]";
	}

}
