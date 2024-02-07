package ccc.j2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q5v2 {
	
	private int numRows, numCols;
	private int room[][];
	boolean visited[][];
	
	public Q5v2() {
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
		return runStep(1, 1);
	}
	
	private boolean runStep(int r, int c) {
//		System.out.println("r = " + r + ", c = " + c);
		if (r == numRows && c == numCols) {
			return true;
		} else {
			visited[r - 1][c - 1] = true;
			List<List<Integer>> factors = getFactors(room[r - 1][c - 1]);
			for (List<Integer> factor : factors) {
				int r0 = factor.get(0);
				int c0 = factor.get(1);
				if ((r0 == r && c0 == c)) continue;
				if (!visited[r0 - 1][c0 - 1]) {
					visited[r0 - 1][c0 - 1] = true;
					if (runStep(r0, c0)) {
						return true;
					}
				}
			}
			return false;
		}
		
	}
	
	private List<List<Integer>> getFactors(int num) {
		List<List<Integer>> factors = new ArrayList<>();
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				if (i <= numRows && num / i <= numCols) {
					factors.add(Arrays.asList(i, num / i));
				}
			}
		}
		return factors;
	}

	public static void main(String[] args) {
		
		Q5v2 q4 = new Q5v2();
		long time = System.currentTimeMillis();
		System.out.println(q4.run() ? "yes" : "no");
		time = System.currentTimeMillis() - time;
		System.out.println("time = " + time);
		
	}

}
