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

public class Q4v2_noworking {
	
	static class PersonPair {
		public String name1, name2;

		public PersonPair(String name1, String name2) {
			this.name1 = name1;
			this.name2 = name2;
		}

		@Override
		public String toString() {
			return "[" + name1 + ", " + name2 + "]";
		}
		
	}
	
	private List<PersonPair> peopleRequiredInSameGroup = new ArrayList<>();
	private List<PersonPair> peopleRequiredNotInSameGroup = new ArrayList<>();
	private List<Set<String>> groups = new ArrayList<>();
	
	public Q4v2_noworking() {
		try (LineNumberReader lnReader = new LineNumberReader(new InputStreamReader(System.in))) {
			int numLines = Integer.parseInt(lnReader.readLine());
			for (int i = 0; i < numLines; i++) {
				String line = lnReader.readLine();
				StringTokenizer st = new StringTokenizer(line);
				peopleRequiredInSameGroup.add(new PersonPair(st.nextToken(), st.nextToken()));
			}
			numLines = Integer.parseInt(lnReader.readLine());
			for (int i = 0; i < numLines; i++) {
				String line = lnReader.readLine();
				StringTokenizer st = new StringTokenizer(line);
				peopleRequiredNotInSameGroup.add(new PersonPair(st.nextToken(), st.nextToken()));
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
		for (PersonPair pair : peopleRequiredInSameGroup) {
			sb.append("  " + pair + "\n");
		}
		sb.append("\n\nPeople Required Not in SameGroup:\n");
		for (PersonPair pair : peopleRequiredNotInSameGroup) {
			sb.append("  " + pair + "\n");
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
				System.out.println("Group #" + k + " violations: " + violatedRules.size() + ", rule 1: " + peopleRequiredInSameGroup.size() + ", rule 2: " + peopleRequiredNotInSameGroup.size());
			k++;
			checkGroupViolations(group, violatedRules);
		}
		return violatedRules.size();
	}
	
	private void checkGroupViolations(Set<String> group, Set<Integer> violatedRule) {
		for (int i = peopleRequiredInSameGroup.size() - 1; i >= 0; i--) {
			if (!violatedRule.contains(i) && group.contains(peopleRequiredInSameGroup.get(i).name1) ^ group.contains(peopleRequiredInSameGroup.get(i).name2)) {
//				System.out.println(Arrays.toString(group.toArray()) + " violates same-group-rule: " + peopleRequiredInSameGroup.get(i));
				violatedRule.add(i);
				peopleRequiredInSameGroup.remove(i);
			}
		}
		for (int i = peopleRequiredNotInSameGroup.size() - 1; i >= 0; i--) {
			if (!violatedRule.contains(100000 + i) && group.contains(peopleRequiredNotInSameGroup.get(i).name1) && group.contains(peopleRequiredNotInSameGroup.get(i).name2)) {
//				System.out.println(Arrays.toString(group.toArray()) + " violates not-same-group-rule: " + Arrays.toString(peopleRequiredNotInSameGroup[i]));
				violatedRule.add(100000 + i);
				peopleRequiredNotInSameGroup.remove(i);
			}
		}
	}

	public static void main(String[] args) {
		
		Q4v2_noworking q4 = new Q4v2_noworking();
//		System.out.println(q4);
		System.out.println("Start checking ...");
		System.out.println(q4.checkViolations());
		
	}

}
