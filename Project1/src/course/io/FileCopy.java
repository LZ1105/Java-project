package course.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FileCopy {

	public FileCopy() {}

	public static void main(String[] args) {
//		copyBinaryFile("D:\\test\\test1.bmp", "D:\\test\\test2.bmp");
//		copyTextFile("D:\\test\\test1.txt", "D:\\test\\test2.txt");
//		copyImprovedBinaryFile("D:\\test\\test1.txt", "D:\\test\\test2.txt");
//		copyFileAddLineNumber("D:\\work\\workspaces\\lucas-workspace\\lucas\\Java-project\\Project1\\src\\course\\io\\FileCopy.java", 
//				"D:\\test\\FileCopy.java");
//		displayFileContent("D:\\work\\workspaces\\lucas-workspace\\lucas\\Java-project\\Project1\\src\\course\\io\\FileCopy.java",
//				";");
		calculateAddition();

	}

	private static void calculateAddition() {
		double sum = 0;
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Please enter your numbers (ENTER to commit data, CTRL+Z to terminate): ");
			while (scanner.hasNextDouble()) {
				double num = scanner.nextDouble();
				sum += num;
				System.out.println("\nNumber read: " + num);
				System.out.print("Please enter your numbers (ENTER to commit data, CTRL+Z to terminate): ");
			}
			System.out.println("\nsum = " + sum);
		}
	}

	private static void displayFileContent(String filename, String delimiter) {
		try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
			scanner.useDelimiter(Pattern.compile(delimiter));
			while (scanner.hasNext()) {
				System.out.println(scanner.next());
				System.out.println("----------------------------------------------------------");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void copyFileAddLineNumber(String sourceFilename, String targetFilename) {
		try (BufferedReader br = new BufferedReader(new FileReader(sourceFilename));
			 BufferedWriter bw = new BufferedWriter(new FileWriter(targetFilename));) {
			int lineNumber = 1;
			String line = br.readLine();
			while (line != null) {
				bw.write(lineNumber + ": " + line + "\n");
				lineNumber++;
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void copyTextFile(String sourceFilename, String targetFilename) {
		try (FileReader fr = new FileReader(sourceFilename);
			 FileWriter fw = new FileWriter(targetFilename);) {
			int b = fr.read();
			while (b != -1) {
				fw.write(b);
				b = fr.read();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void copyBinaryFile(String sourceFilename, String targetFilename) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(sourceFilename);
			fos = new FileOutputStream(targetFilename);
			int b = fis.read();
			while (b != -1) {
				fos.write(b);
				b = fis.read();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {}
			try {
				if (fos != null)
					fos.close();
			} catch (IOException e) {}
		}
	}

	private static void copyImprovedBinaryFile(String sourceFilename, String targetFilename) {
		byte buffer[] = new byte[1024];
		try (
			FileInputStream fis = new FileInputStream(sourceFilename);
			FileOutputStream fos = new FileOutputStream(targetFilename); ) {
			int len = fis.read(buffer);
			while (len != -1) {
				System.out.println("len = " + len);
				fos.write(buffer, 0, len);
				len = fis.read(buffer);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
