package ccc.j2021;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Q4 {
	
	private char books[];
	
	public Q4() {
		try (LineNumberReader lnReader = new LineNumberReader(new InputStreamReader(System.in))) {
			books = lnReader.readLine().toCharArray();
		} catch (IOException e) {
			e.printStackTrace(System.err);
		}
	}
	
	@Override
	public String toString() {
		return Arrays.toString(books);
	}
	
	public int arrange() {
		// init: L = first no-Large from left, S = first no-Small from right, M1 = first M, M2 = last M
		// if Books[L] = Small:
		//		if Book[S] = Large: 
		//			swap L and S
		//          L++, S--
		// 			while Books[L+1] != Large: L++
		// 			while Books[S-1] != Small: S--
		//		elif Book[S-1] = Medium:
		//			swap L and S
		//			S--, M1 = L
		//			while Books[S-1] != Small: S--
		//		elif Book[S-1] = Small: impossible
		// elif Boos[L] = Medium:
		//		if Books[S] = Large:
		//			swap L and S
		//			L++, M2 = S
		//			while Books[L+1] != Large: L++
		//		elif Books[S] = Small: impossible
		//		elif Books[S] = Medium:
		//			Let k = L+1
		//			while Books[K] != Large && k < M2:
		//				if Books[K] == Small:
		//					swap k and M2
		// ... pause here ...
		// elif Boos[L] = Large: impossible
		// if 
//		int numSwaps = 0;
//		int largeIndex = 0;
//		int smallIndex = books.length - 1;
//		while (largeIndex < smallIndex) {
//			if (books[largeIndex] != 'L' || books[smallIndex] != 'S') {
//				char book = books[largeIndex];
//				books[largeIndex] = books[smallIndex];
//				books[smallIndex] = book;
//				if (books[largeIndex] == 'L') {
//					largeIndex++;
//				}
//				if (books[smallIndex] == 'S') {
//					smallIndex--;
//				}
//				numSwaps++;
//			} else {
//				largeIndex++;
//				smallIndex--;
//			}
//		}
		
//		char sortedBooks[] = new char[books.length];
		int largeIndex = -1, smallIndex = books.length;
		for (char book : books) {
			if (book == 'L') {
//				sortedBooks[largeIndex++] = 'L';
				largeIndex++;
			} else if (book == 'S') {
//				sortedBooks[smallIndex++] = 'L';
				smallIndex--;
			}
		}
		int numSmallBooksInLargeSection = 0;
		int numMediumBooksInLargeSection = 0;
		for (int i = 0; i <= largeIndex; i++) {
			if (books[i] == 'S') {
				numSmallBooksInLargeSection++;
			} else if (books[i] == 'M') {
				numMediumBooksInLargeSection++;
			}
		}
		int numSmallBooksInMediumSection = 0;
		int numLargeBooksInMediumSection = 0;
		for (int i = largeIndex + 1; i < smallIndex; i++) {
			if (books[i] == 'S') {
				numSmallBooksInMediumSection++;
			} else if (books[i] == 'L') {
				numLargeBooksInMediumSection++;
			}
		}
		int numLargeBooksInSmallSection = 0;
		int numMediumBooksInSmallSection = 0;
		for (int i = smallIndex; i < books.length; i++) {
			if (books[i] == 'L') {
				numLargeBooksInSmallSection++;
			} else if (books[i] == 'M') {
				numMediumBooksInSmallSection++;
			}
		}
		
//		System.out.println("numSmallBooksInLargeSection  = " + numSmallBooksInLargeSection);
//		System.out.println("numMediumBooksInLargeSection = " + numMediumBooksInLargeSection);
//		System.out.println("numSmallBooksInMediumSection = " + numSmallBooksInMediumSection);
//		System.out.println("numLargeBooksInMediumSection = " + numLargeBooksInMediumSection);
//		System.out.println("numMediumBooksInSmallSection = " + numMediumBooksInSmallSection);
//		System.out.println("numLargeBooksInSmallSection  = " + numLargeBooksInSmallSection);
//		System.out.println("-----------------------------------------------");

		// Swap small books in Large section with large books in Small section
		int numSwaps = Math.min(numSmallBooksInLargeSection, numLargeBooksInSmallSection);
		if (numSmallBooksInLargeSection > numLargeBooksInSmallSection) { // S-L-M
			numSmallBooksInLargeSection -= numLargeBooksInSmallSection;
			numLargeBooksInSmallSection = 0;
		} else {	// M-L-S
			numLargeBooksInSmallSection -= numSmallBooksInLargeSection;
			numSmallBooksInLargeSection = 0;
		}

		// Swap medium books in Large section with large books in Medium section
		numSwaps += Math.min(numMediumBooksInLargeSection, numLargeBooksInMediumSection);
		numMediumBooksInLargeSection -= Math.min(numMediumBooksInLargeSection, numLargeBooksInMediumSection);
		numLargeBooksInMediumSection -= Math.min(numMediumBooksInLargeSection, numLargeBooksInMediumSection);
		
		// Swap medium books in Small section with small books in Medium section
		numSwaps += Math.min(numMediumBooksInSmallSection, numSmallBooksInMediumSection);
		numMediumBooksInSmallSection -= Math.min(numMediumBooksInSmallSection, numSmallBooksInMediumSection);
		numSmallBooksInMediumSection -= Math.min(numMediumBooksInSmallSection, numSmallBooksInMediumSection);
		
		if (numSmallBooksInLargeSection > 0) { // S-L-M
			numSwaps += numSmallBooksInLargeSection * 2;
		} else { // M-S-L
			numSwaps += numLargeBooksInSmallSection * 2;
		}
		
//		System.out.println("numSmallBooksInLargeSection  = " + numSmallBooksInLargeSection);
//		System.out.println("numMediumBooksInLargeSection = " + numMediumBooksInLargeSection);
//		System.out.println("numSmallBooksInMediumSection = " + numSmallBooksInMediumSection);
//		System.out.println("numLargeBooksInMediumSection = " + numLargeBooksInMediumSection);
//		System.out.println("numMediumBooksInSmallSection = " + numMediumBooksInSmallSection);
//		System.out.println("numLargeBooksInSmallSection  = " + numLargeBooksInSmallSection);

		return numSwaps;
	}

	public static void main(String[] args) {
		
		Q4 q4 = new Q4();
//		System.out.println(q4);
//		System.out.println("Start checking ...");
		System.out.println(q4.arrange());
		
	}

}
