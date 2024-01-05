package course.nested_classes.method_ref;

import course.nested_classes.Student;

public class StudentUtil {

	static void increaseAge(Student stu) {
		stu.setAge(stu.getAge() + 1);
	}
}
