package course.nested_classes.streams;

import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		int r = s1.getFirstName().compareTo(s2.getFirstName());
		if (r == 0) {
			r = s1.getLastName().compareTo(s2.getLastName());
		}
		return r;
	}

}
