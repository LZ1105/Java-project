package course.enum_and_constants;

public enum Grade {
	A ("A", 0.9, "excellent"), 
	B ("B", 0.8, "good"), 
	C ("C", 0.7, "normal"), 
	Pass ("P", 0.6, "average"), 
	Fail ("F", 0.599, "not-working-hard-enough");

	Grade(String label, double minScore, String description) {
		this.label = label;
		this.minScore = minScore;
		this.description = description;
	}
	
	private String label;
	private double minScore;
	private String description;
	
	public String getLabel() {
		return label;
	}
	
	public String getDescription() {
		return description;
	}
	
	public double getMinScore() {
		return minScore;
	}

	public static Grade fromLabel(String label) {
		for (Grade g : values()) {
			if (g.label.equals(label)) {
				return g;
			}
		}
		return null;
	}
	
	public static Grade fromName(String name) {
		return valueOf(name);
	}
	
	

}
