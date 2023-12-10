package course.enum_and_constants;

public class Student {
	
	private String name;
	private double score;
	private double rate;
	private boolean examPassed;
	private Grade grade;
	
	public Student() {}

	public Student(String name, double score) {
		super();
		this.name = name;
		this.score = score;
	}
	
	public Student(OldStudent oldStudent) {
		this.name = oldStudent.getName();
		this.score = oldStudent.getScore();
		this.rate = oldStudent.getRate();
		this.examPassed = oldStudent.isExamPassed();
		// this.grade = oldStudent.getGrade();
//		if (oldStudent.getGrade().equals(OldStudent.GRADE_A)) {
//			this.grade = Grade.A;
//		} else if (...) { ... } 
//		this.grade = Grade.valueOf(oldStudent.getGrade());
		this.grade = Grade.fromLabel(oldStudent.getGrade());
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

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
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
		return "Student [name=" + name + " (a/an " + grade.getDescription() + " student), score=" + score + ", rate=" + rate + ", examPassed=" + examPassed
				+ ", grade=" + grade.getLabel() + "]";
	}

}
