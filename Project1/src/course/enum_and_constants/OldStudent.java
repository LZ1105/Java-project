package course.enum_and_constants;

public class OldStudent {
	
	public static final String GRADE_A = "A";
	public static final String GRADE_B = "B";
	public static final String GRADE_C = "C";
	public static final String GRADE_P = "P";
	public static final String GRADE_F = "F";
	
	private String name;
	private double score;
	private double rate;
	private boolean examPassed;
	private String grade;
	
	public OldStudent() {}

	public OldStudent(String name, double score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public boolean isExamPassed() {
		return examPassed;
	}

	public void setExamPassed(boolean examPassed) {
		this.examPassed = examPassed;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + ", rate=" + rate + ", examPassed=" + examPassed
				+ ", grade=" + grade + "]";
	}

}
