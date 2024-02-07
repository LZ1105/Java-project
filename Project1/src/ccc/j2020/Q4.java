package ccc.j2020;

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
	
	public Q4() {
	}
	
	public boolean check() {
		try (LineNumberReader lnReader = new LineNumberReader(new InputStreamReader(System.in))) {
			String T = lnReader.readLine();
			String S = lnReader.readLine();
			for(int i = 0; i < S.length(); i++) { 
				if (T.indexOf(S) >= 0) {
					return true;
				}
				S = S.substring(1) + S.charAt(0);
			}
		} catch (IOException e) {}
		return false;
	}

	public static void main(String[] args) {
		
		Q4 q4 = new Q4();
		System.out.println(q4.check() ? "yes" : "no");
		
	}

}
