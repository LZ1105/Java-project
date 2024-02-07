package ccc.j2021;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q5 {
	
	private int numRows, numCols;
	
	public Q5() {
//		try (LineNumberReader lnReader = new LineNumberReader(new InputStreamReader(System.in))) {
//			numRows = Integer.parseInt(lnReader.readLine());
//			numCols = Integer.parseInt(lnReader.readLine());
//		} catch (IOException e) {
//			e.printStackTrace(System.err);
//		}
	}
	
	public int calculate() {
		int numGoldenCells = 0;
		int numRows, numCols;
		Set<Integer> effectivePaintedRows = new HashSet<>();
		Set<Integer> effectivePaintedCols = new HashSet<>();
		try (LineNumberReader lnReader = new LineNumberReader(new InputStreamReader(System.in))) {
			numRows = Integer.parseInt(lnReader.readLine());
			numCols = Integer.parseInt(lnReader.readLine());
			int totalSteps = Integer.parseInt(lnReader.readLine());
			for (int i = 0; i < totalSteps; i++) {
				String line = lnReader.readLine();
				StringTokenizer st = new StringTokenizer(line);
				char type = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());
				if (type == 'R') {
					if (effectivePaintedRows.contains(num)) {
						effectivePaintedRows.remove(num);
					} else {
						effectivePaintedRows.add(num);
					}
				} else { // type == 'C'
					if (effectivePaintedCols.contains(num)) {
						effectivePaintedCols.remove(num);
					} else {
						effectivePaintedCols.add(num);
					}
				}
			}
			return effectivePaintedRows.size() * numCols +
					effectivePaintedCols.size() * numRows -
					effectivePaintedRows.size() * effectivePaintedCols.size() * 2;
		} catch (IOException e) {
			e.printStackTrace(System.err);
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		Q5 q5 = new Q5();
		int result = q5.calculate();
		System.out.println(result);
	}

}
