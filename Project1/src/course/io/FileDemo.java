package course.io;

import java.io.File;
import java.util.Calendar;

public class FileDemo {

	public static void main(String[] args) {
		getFileInfo("D:\\test\\students2.dat");
		getFileInfo("D:\\test\\students3.dat");
		printAllFileSizeAndLastModifiedDate("C:\\temp", "file");
	}

	// Print size and last-modified-date of all files with a prefix of filenamePrefix 
	// under folderName, including sub-folders recursively
	// Example:
	//   C:\temp\file-1.txt   123 Sun Jan 14 15:46:12 EST 2024
	//   C:\temp\folder1\file-2.txt   321 Sun Jan 14 15:46:12 EST 2024
	//   C:\temp\folder2\folder2a\files.dat  111 Sun Jan 14 15:46:12 EST 2024
	private static void printAllFileSizeAndLastModifiedDate(String folderName, String filenamePrefix) {
		
	}

	private static void getFileInfo(String filename) {
		File file = new File(filename);
		if (file.exists()) {
			System.out.println("absolutePath: " + file.getAbsolutePath());
			System.out.println("length: " + file.length());
			Calendar fileDate = Calendar.getInstance();
			fileDate.setTimeInMillis(file.lastModified());
			System.out.println("length: " + fileDate.getTime());
		} else {
			System.out.println("File does not exist: " + filename);
		}

		
	}

}
