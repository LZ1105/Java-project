package ccc.j2022;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Q4v1 {

	private String peopleRequiredInSameGroup[][];
	private String peopleRequiredNotInSameGroup[][];
	private List<Set<String>> groups = new ArrayList<>();
	
	public Q4v1() {
		try (LineNumberReader lnReader = new LineNumberReader(new InputStreamReader(System.in))) {
			int numLines = Integer.parseInt(lnReader.readLine());
			peopleRequiredInSameGroup = new String[numLines][2];
			for (int i = 0; i < numLines; i++) {
				String line = lnReader.readLine();
				StringTokenizer st = new StringTokenizer(line);
				peopleRequiredInSameGroup[i][0] = st.nextToken();
				peopleRequiredInSameGroup[i][1] = st.nextToken();
			}
			numLines = Integer.parseInt(lnReader.readLine());
			peopleRequiredNotInSameGroup = new String[numLines][2];
			for (int i = 0; i < numLines; i++) {
				String line = lnReader.readLine();
				StringTokenizer st = new StringTokenizer(line);
				peopleRequiredNotInSameGroup[i][0] = st.nextToken();
				peopleRequiredNotInSameGroup[i][1] = st.nextToken();
			}
			numLines = Integer.parseInt(lnReader.readLine());
			for (int i = 0; i < numLines; i++) {
				Set<String> group = new HashSet<>();
				String line = lnReader.readLine();
				StringTokenizer st = new StringTokenizer(line);
				while(st.hasMoreTokens()) {
					group.add(st.nextToken());
				}
				groups.add(group);
			}
		} catch (IOException e) {
			e.printStackTrace(System.err);
		}
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("People Required in Same Group:\n");
		for (int i = 0; i < peopleRequiredInSameGroup.length; i++) {
			sb.append("  " + Arrays.toString(peopleRequiredInSameGroup[i]));
		}
		sb.append("\n\nPeople Required Not in SameGroup:\n");
		for (int i = 0; i < peopleRequiredNotInSameGroup.length; i++) {
			sb.append("  " + Arrays.toString(peopleRequiredNotInSameGroup[i]));
		}
		sb.append("\n\nGroups:\n");
		for (int i = 0; i < groups.size(); i++) {
			sb.append("  Group #" + (i + 1) + ": " + Arrays.toString(groups.get(i).toArray()) + "\n");
		}
		return sb.toString();
	}
	
	public int checkViolations() {
		Set<Integer> violatedRules = new HashSet<>();
		int k = 1;
		for (Set<String> group : groups) {
			if (k % 1000 == 0)
				System.out.println("Group #" + k);
			k++;
			checkGroupViolations(group, violatedRules);
		}
		return violatedRules.size();
	}
	
	private void checkGroupViolations(Set<String> group, Set<Integer> violatedRule) {
		for (int i = 0; i < peopleRequiredInSameGroup.length; i++) {
			if (!violatedRule.contains(i) && group.contains(peopleRequiredInSameGroup[i][0]) ^ group.contains(peopleRequiredInSameGroup[i][1])) {
//				System.out.println(Arrays.toString(group.toArray()) + " violates same-group-rule: " + Arrays.toString(peopleRequiredInSameGroup[i]));
				violatedRule.add(i);
			}
		}
		for (int i = 0; i < peopleRequiredNotInSameGroup.length; i++) {
			if (!violatedRule.contains(100000 + i) && group.contains(peopleRequiredNotInSameGroup[i][0]) && group.contains(peopleRequiredNotInSameGroup[i][1])) {
//				System.out.println(Arrays.toString(group.toArray()) + " violates not-same-group-rule: " + Arrays.toString(peopleRequiredNotInSameGroup[i]));
				violatedRule.add(100000 + i);
			}
		}
	}

	public static void main(String[] args) {
		
		Q4v1 q4 = new Q4v1();
//		System.out.println(q4);
		System.out.println("Start checking ...");
		System.out.println(q4.checkViolations());
		
	}

}
