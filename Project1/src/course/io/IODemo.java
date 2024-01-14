package course.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class IODemo {

	public static void main(String[] args) {
		
//		List<Student> students = new ArrayList<>();
//		students.add(new Student("John", "Smith", 30, "M", new Address("101 Yonge st.", "Toronto", "Ontario", "M1A 2BC")));
//		students.add(new Student("Mary", "Poppins", 32, "F", new Address("102 Yonge st.", "Toronto", "Ontario", "M1A 2BC")));
//		students.add(new Student("John", "Brown", 33, "M", new Address("103 Yonge st.", "Toronto", "Ontario", "M1A 2BC")));
//		students.add(new Student("Steve", "Green", 21, "M", new Address("104 Yonge st.", "Toronto", "Ontario", "M1A 2BC")));
//		students.add(new Student("Alice", "Smith", 33, "F", new Address("105 Yonge st.", "Toronto", "Ontario", "M1A 2BC")));
//		
//		printStudents(students);
////		saveStudentsToFile(students, "D:\\test\\students.txt");
////		saveStudentsToDataFile(students, "D:\\test\\students.dat");
//		saveStudentsToObjectDataFile(students, "D:\\test\\students2.dat");
		
//		List<Student> students = readStudentsFromFile("D:\\test\\students.txt");
//		List<Student> students = readStudentsFromDataFile("D:\\test\\students.dat");
		List<Student> students = readStudentsFromObjectDataFile("D:\\test\\students2.dat");
		printStudents(students);
		
	}
	
	private static List<Student> readStudentsFromObjectDataFile(String filename) {
		List<Student> students = new ArrayList<>();
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			while (true) {
				Student s = (Student) ois.readObject();
				students.add(s);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
//			e.printStackTrace();
			System.out.println("Reach the end of the file.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return students;
	}

	private static void saveStudentsToObjectDataFile(List<Student> students, String filename) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			for (Student s : students) {
				oos.writeObject(s);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	private static List<Student> readStudentsFromDataFile(String filename) {
		List<Student> students = new ArrayList<>();
		try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
			while (true) {
				String firstName = dis.readUTF();
				String lastName = dis.readUTF();
				int age = dis.readInt();
				String gender = dis.readUTF();
				String addrStreet = dis.readUTF();
				String addrCity = dis.readUTF();
				String addrProvince = dis.readUTF();
				String addrPostalCode = dis.readUTF();
				students.add(new Student(firstName, lastName, age, gender, 
						new Address(addrStreet, addrCity, addrProvince, addrPostalCode)));
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
//			e.printStackTrace();
			System.out.println("Reach the end of the file.");
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return students;
	}

	private static void saveStudentsToDataFile(List<Student> students, String filename) {
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
			for (Student s : students) {
				dos.writeUTF(s.getFirstName());
				dos.writeUTF(s.getLastName());
				dos.writeInt(s.getAge());
				dos.writeUTF(s.getGender());
				dos.writeUTF(s.getAddress().getStreet());
				dos.writeUTF(s.getAddress().getCity());
				dos.writeUTF(s.getAddress().getProvince());
				dos.writeUTF(s.getAddress().getPostalCode());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	private static List<Student> readStudentsFromFile(String filename) {
		List<Student> students = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line = br.readLine();
			while (line != null) {
				String firstName = line.substring(0, 32).trim();
				String lastName = line.substring(32, 64).trim();
				int age = Integer.parseInt(line.substring(64, 67).trim());
				String gender = line.substring(67, 68).trim();
				String addrStreet = line.substring(68, 100).trim();
				String addrCity = line.substring(100, 132).trim();
				String addrProvince = line.substring(132, 164).trim();
				String addrPostalCode = line.substring(164).trim();
				students.add(new Student(firstName, lastName, age, gender, 
						new Address(addrStreet, addrCity, addrProvince, addrPostalCode)));
				
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return students;
	}

	private static void saveStudentsToFile(List<Student> students, String filename) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
			for (Student s : students) {
				String record = String.format("%32s%32s%3d%1s%32s%32s%32s%7s",
						s.getFirstName(), s.getLastName(), s.getAge(), s.getGender(),
						s.getAddress().getStreet(), s.getAddress().getCity(),
						s.getAddress().getProvince(), s.getAddress().getPostalCode());
				bw.write(record + "\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}



	private static void printStudents(List<Student> students) {
		for (Student s : students) {
			System.out.println(s);
		}
	}

}
