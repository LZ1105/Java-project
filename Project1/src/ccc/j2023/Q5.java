package ccc.j2023;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q5 {
	
	char searchWord[];
	char letters[][];
	int numRows, numCols;
	
	enum Direction {
		All,
		East, West, North, South,
		NorthEast, NorthWest, SouthEast, SouthWest;
	}
	
	public Q5() {
		try (LineNumberReader lnReader = new LineNumberReader(new InputStreamReader(System.in))) {
			String searchWordStr = lnReader.readLine();
			searchWord = searchWordStr.toCharArray();
			numRows = Integer.parseInt(lnReader.readLine());
			numCols = Integer.parseInt(lnReader.readLine());
			letters = new char[numRows][numCols];
			for (int i = 0; i < numRows; i++) {
				String line = lnReader.readLine();
				StringTokenizer st = new StringTokenizer(line);
				for (int j = 0; j < numCols; j++) {
					letters[i][j] = st.nextToken().charAt(0);
				}
			}
		} catch (IOException e) {
			e.printStackTrace(System.err);
		}
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer(Arrays.toString(searchWord) + "\n");
		for (int i = 0; i < numRows; i++) {
			sb.append(Arrays.toString(letters[i]) + "\n");
		}
		return sb.toString();
	}
	
	public int searchWord(int row, int col, int searchWordIndex, boolean canTurn, Direction direction, String wordFound) {
		int result = 0;
//		if (searchWordIndex == searchWord.length) {
//			System.out.println("wordFound: " + wordFound);
//			return 1;
//		}
		if (row < 0 || col < 0 || row >= numRows || col >= numCols) {
			return 0;
		} else if (letters[row][col] == searchWord[searchWordIndex]) {
			if (searchWordIndex == searchWord.length - 1) {
				wordFound += letters[row][col] + "(" + row + "," + col + "-" + direction + ") ";
//				System.out.println("wordFound: " + wordFound);
				return 1;
			} else {
				wordFound += letters[row][col] + "(" + row + "," + col + "-" + direction + ") ";
				if (direction == Direction.All || direction == Direction.East || canTurn && (direction == Direction.North || direction == Direction.South)) {
					result += searchWord(row, col + 1, searchWordIndex + 1, canTurn && (direction == Direction.All || direction == Direction.East), Direction.East, wordFound);
				}
				if (direction == Direction.All || direction == Direction.South || canTurn && (direction == Direction.East || direction == Direction.West)) {
					result += searchWord(row + 1, col, searchWordIndex + 1, canTurn && (direction == Direction.All || direction == Direction.South), Direction.South, wordFound);
				}
				if (direction == Direction.All || direction == Direction.West || canTurn && (direction == Direction.North || direction == Direction.South)) {
					result += searchWord(row, col - 1, searchWordIndex + 1, canTurn && (direction == Direction.All || direction == Direction.West), Direction.West, wordFound);
				}
				if (direction == Direction.All || direction == Direction.North || canTurn && (direction == Direction.East || direction == Direction.West)) {
					result += searchWord(row - 1, col, searchWordIndex + 1, canTurn && (direction == Direction.All || direction == Direction.North), Direction.North, wordFound);
				}
				if (direction == Direction.All || direction == Direction.SouthEast || canTurn && (direction == Direction.NorthEast || direction == Direction.SouthWest)) {
					result += searchWord(row + 1, col + 1, searchWordIndex + 1, canTurn && (direction == Direction.All || direction == Direction.SouthEast), Direction.SouthEast, wordFound);
				}
				if (direction == Direction.All || direction == Direction.NorthEast || canTurn && (direction == Direction.SouthEast || direction == Direction.NorthWest)) {
					result += searchWord(row - 1, col + 1, searchWordIndex + 1, canTurn && (direction == Direction.All || direction == Direction.NorthEast), Direction.NorthEast, wordFound);
				}
				if (direction == Direction.All || direction == Direction.SouthWest || canTurn && (direction == Direction.SouthEast || direction == Direction.NorthWest)) {
					result += searchWord(row + 1, col - 1, searchWordIndex + 1, canTurn && (direction == Direction.All || direction == Direction.SouthWest), Direction.SouthWest, wordFound);
				}
				if (direction == Direction.All || direction == Direction.NorthWest || canTurn && (direction == Direction.NorthEast || direction == Direction.SouthWest)) {
					result += searchWord(row - 1, col - 1, searchWordIndex + 1, canTurn && (direction == Direction.All || direction == Direction.NorthWest), Direction.NorthWest, wordFound);
				}
			}
		}
		
		return result;
	}

	public int search() {
		int result = 0;
		
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				result += searchWord(i, j, 0, true, Direction.All, "");
			}
		}
		
		
		return result;
	}

	public static void main(String[] args) {
		Q5 q5 = new Q5();
//		System.out.println(q5);
		System.out.println(q5.search());
	}

}
