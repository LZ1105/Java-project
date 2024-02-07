package ccc.j2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q5v3 {
	
	private int numRows, numCols;
	private int room[][];
	boolean visited[][];
	
	public Q5v3() {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			numRows = Integer.parseInt(reader.readLine());
			numCols = Integer.parseInt(reader.readLine());
			room = new int[numRows][numCols];
			visited = new boolean[numRows][numCols];
			for(int i = 0; i < numRows; i++) { 
				String line = reader.readLine();
				StringTokenizer st = new StringTokenizer(line);
				for (int j = 0; j < numCols; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		} catch (IOException e) {
			e.printStackTrace(System.err);
		}
	}
	
	public boolean run() {
		for(int i = 0; i < numRows; i++) { 
			Arrays.fill(visited[i], false);
		}
		visited[numRows - 1][numCols - 1] = true;
		return runStep(numRows, numCols);
	}
	
	private boolean runStep(int r, int c) {
//		System.out.println("r = " + r + ", c = " + c);
		// TODO: fix this, then try BFS
		if (r == 1 && c == 1) return true;
//		if (room[r - 1][c - 1] == 0) return false;
		
		int product = r * c;
		for (int i = 1; i <= numRows; i++) {
			for (int j = 1; j <= numCols; j++) {
//				if (i == r && j == c) continue;
				if (!visited[i - 1][j - 1] && room[i - 1][j - 1] == product) {
//					room[i - 1][j - 1] = 0;
					visited[i - 1][j - 1] = true;
					if (runStep(i, j)) return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		Q5v3 q4 = new Q5v3();
		long time = System.currentTimeMillis();
		System.out.println(q4.run() ? "yes" : "no");
		time = System.currentTimeMillis() - time;
		System.out.println("time = " + time);
		
	}

}
