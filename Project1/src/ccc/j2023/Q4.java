package ccc.j2023;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q4 {
	
	private int numCols = 0;
	private int lines[][];
	
	public Q4() {
		try (LineNumberReader lnReader = new LineNumberReader(new InputStreamReader(System.in))) {
			numCols = Integer.parseInt(lnReader.readLine());
			lines = new int[2][numCols];
			for (int i = 0; i < 2; i++) {
				String line = lnReader.readLine();
				StringTokenizer st = new StringTokenizer(line);
				for (int j = 0; j < numCols; j++) {
					lines[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		} catch (IOException e) {
			e.printStackTrace(System.err);
		}
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("[");
		for (int i = 0; i < 2; i++) {
			sb.append(Arrays.toString(lines[i]));
		}
		sb.append("]");
		return sb.toString();
	}
	
	public int calculateTapLength() {
		int totalLen = 0;
		int row = 0, col1 = 0, col2 = 0;
//		int nextRow = 1, nextCol = 1;
		while (col1 < numCols) {
			if (lines[0][col1] == 0) {
				col1++;
				continue;
			}
			totalLen += 3;
			int nextCol = col1 + 1;
			while (nextCol < numCols && lines[0][nextCol] == 1) {
				totalLen += 1; // + 3 - 2
				nextCol++;
			}
			col1 = nextCol;
		}
		while (col2 < numCols) {
			if (lines[1][col2] == 0) {
				col2++;
				continue;
			}
			totalLen += 3;
			if (col2 % 2 == 0 && lines[0][col2] == 1) {
				totalLen -= 2;
			}
			int nextCol = col2 + 1;
			while (nextCol < numCols && lines[1][nextCol] == 1) {
				totalLen += 1; // + 3 - 2
				if (nextCol % 2 == 0 && lines[0][nextCol] == 1) {
					totalLen -= 2;
				}
				nextCol++;
			}
			col2 = nextCol;
		}
		
		return totalLen;
	}

	public int calculateTapLength2() {
		int totalLen = 0;
		for (int row = 0; row < 2; row++) {
			int col = 0;
			while (col < numCols) {
				if (lines[row][col] == 0) {
					col++;
					continue;
				}
				totalLen += 3;
				if (row == 1 && col % 2 == 0 && lines[0][col] == 1) {
					totalLen -= 2;
				}

				int nextCol = col + 1;
				while (nextCol < numCols && lines[row][nextCol] == 1) {
					totalLen += 1; // + 3 - 2
					if (row == 1 && nextCol % 2 == 0 && lines[0][nextCol] == 1) {
						totalLen -= 2;
					}
					nextCol++;
				}
				col = nextCol;
			}
			
		}
		return totalLen;
	}

	public static void main(String[] args) {
		
		Q4 q4 = new Q4();
//		System.out.println(q4);
		System.out.println(q4.calculateTapLength());
		System.out.println(q4.calculateTapLength2());
		
	}

}
