package course.interfaces;

public class GasolineCar extends Car {
	
	private double gasConsumption; // per 100 km.
	
	public GasolineCar() {}

	public GasolineCar(String brand, String model, double gasConsumption) {
		super(brand, model);
		this.gasConsumption = gasConsumption;
	}

	public double getGasConsumption() {
		return gasConsumption;
	}

	public void setGasConsumption(double gasConsumption) {
		this.gasConsumption = gasConsumption;
	}
	
	
	

}
