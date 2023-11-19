package course.classes_and_objects;

public class Circle {
	
	private double x, y, radius;
	private static double PI = 3.14;

	public Circle(double x, double y, double radius) {
		super();
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public double getPerimeter() {
		return 2 * PI * radius;
	}
	
	public double getArea() {
		return PI * radius * radius;
	}
	
	public static double getPI() {
		return PI;
	}

	public static void setPI(double pI) {
		if (pI >= 3.0 && pI <= 3.15) {
			PI = pI;
		} else {
			System.out.println("Cannot set PI.");
		}
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Circle [x=" + x + ", y=" + y + ", radius=" + radius + "]";
	}


	

}
