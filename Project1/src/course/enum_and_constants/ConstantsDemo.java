package course.enum_and_constants;

/**
 * This is a program that demonstrates the usage of constants from 
 * an old way to the modern way that uses enum classes.
 *  
 * @author Lucks
 * @version 1.0
 * @since Dec, 2023
 * @see course.enum_and_constants.Student
 * @see course.enum_and_constants.Grade
 * @see course.enum_and_constants.OldStudent
 *
 */
public class ConstantsDemo {
	
	// Constants
	/**
	 * The highest score in the marking system.
	 */
	public static final double HIGHEST_MARK = 70; // highest mark
	/**
	 * The lowest score in the marking system, typically is zero.
	 */
	public static final double LOWEST_MARK = 0;
	public static final double PASSING_RATE = 0.6;
	public static final double GRADE_A = 0.9;
	public static final double GRADE_B = 0.8;
	public static final double GRADE_C = 0.7;

	/**
	 * This is main program...
	 * @param args
	 */
	public static void main(String[] args) {
		/* Processing two students using a very old way.
		 * This has been proven as an error-prone way.
		 */
		processStudentTestScore("John", 56.0);
		processStudentTestScore("Johnson", 6.0);
		
		OldStudent s1 = new OldStudent ("John", 56.0);
		OldStudent s2 = new OldStudent ("Johnson", 6.0);
		OldStudent s3 = new OldStudent ("Mary", 43.0);
		processStudentTestScore(s1);
		processStudentTestScore(s2);
		processStudentTestScore(s3);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);

		System.out.println("------------------------------------");
		Student ss1 = new Student ("Alice", 56.0);
		Student ss2 = new Student ("Bob", 6.0);
		Student ss3 = new Student ("Cathy", 43.0);
		processStudentTestScore(ss1);
		processStudentTestScore(ss2);
		processStudentTestScore(ss3);
		System.out.println(ss1);
		System.out.println(ss2);
		System.out.println(ss3);
		
		System.out.println("------------------------------------");
		System.out.println("Grade has the following instances:");
		Grade grades[] = Grade.values();
		for (Grade g : grades) {
			System.out.printf("name = %s, ordinal = %d%n", g.name(), g.ordinal());
		}
		
		System.out.println("------------------------------------");
		Student ss4 = new Student(s1);
		Student ss5 = new Student(s2);
		Student ss6 = new Student(s3);
		System.out.println(ss4);
		System.out.println(ss5);
		System.out.println(ss6);
	}

	/**
	 * Calculates the rate, examPassed and grade of a student using its
	 * currently assigned score.
	 * @param student a Student object that should have the name and score set.
	 */
	private static void processStudentTestScore(Student student) {
		student.setRate(student.getScore() / HIGHEST_MARK);
		student.setExamPassed(student.getRate() >= PASSING_RATE);
		
		if (student.getRate() >= Grade.A.getMinScore()) {
			student.setGrade(Grade.A);
		} else if (student.getRate() >= Grade.B.getMinScore()) {
			student.setGrade(Grade.B);
		} else if (student.getRate() >= Grade.C.getMinScore()) {
			student.setGrade(Grade.C);
		} else if (student.getRate() >= Grade.Pass.getMinScore()) {
			student.setGrade(Grade.Pass);
		} else {
			student.setGrade(Grade.Fail);
		}
	}
	
	/**
	 * Calculates the result of a divide by b. 
	 * @param a the numerator
	 * @param b the denomenator
	 * @return the result of a / b
	 * @throws Exception when b is zero
	 */
	public double div(double a, double b) throws Exception {
		if (b == 0) {
			throw new Exception("Denom is zero.");
		}
		return a / b;
	}

	private static void processStudentTestScore(OldStudent student) {
		student.setRate(student.getScore() / HIGHEST_MARK);
		student.setExamPassed(student.getRate() >= PASSING_RATE);
		
		if (student.getRate() >= GRADE_A) {
			student.setGrade(OldStudent.GRADE_A);
		} else if (student.getRate() >= GRADE_B) {
			student.setGrade(OldStudent.GRADE_B);
		} else if (student.getRate() >= GRADE_C) {
			student.setGrade(OldStudent.GRADE_C);
		} else if (student.getRate() >= PASSING_RATE) {
			student.setGrade(OldStudent.GRADE_P);
		} else {
			student.setGrade(OldStudent.GRADE_F);
		}
	}

	private static void processStudentTestScore(String name, double score) {
		
		double rate = score / HIGHEST_MARK;
//		System.out.print("Hi " + name + ", your rate is " + rate + ". ");
		System.out.printf("Hi %10s, your rate is %6.1f%%.", name, rate * 100);
		if (rate >= PASSING_RATE) {
			System.out.print("You have passed the exame. ");
		} else {
			System.out.print("You didn't pass the exam. ");
		}
		
		if (rate >= GRADE_A) {
			System.out.println("Your grade is A.");
		} else if (rate >= GRADE_B) {
			System.out.println("Your grade is B.");
		} else if (rate >= GRADE_C) {
			System.out.println("Your grade is C.");
		} else if (rate >= PASSING_RATE) {
			System.out.println("Your grade is P.");
		} else {
			System.out.println("Your grade is F.");
		}
		
	}

}
