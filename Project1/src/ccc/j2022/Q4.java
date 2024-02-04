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

public class Q4 {
	
	private static int RULE_NO_SEED = 1;
	
	static class Rule {
		public int ruleNo;
		public String name1, name2;

		public Rule(String name1, String name2) {
			this.ruleNo = RULE_NO_SEED++;
			this.name1 = name1;
			this.name2 = name2;
		}
		
		public boolean isViolate(Set<String> group, boolean needsInSameGroup) {
			if (needsInSameGroup) {
				return group.contains(name1) ^ group.contains(name2);
			} else {
				return group.contains(name1) && group.contains(name2);
			}
		}

		@Override
		public String toString() {
			return "[R" +  ruleNo + ": " + name1 + ", " + name2 + "]";
		}
		
	}
	
	private List<Rule> peopleRequiredInSameGroup = new ArrayList<>();
	private List<Rule> peopleRequiredNotInSameGroup = new ArrayList<>();
	private List<Set<String>> groups = new ArrayList<>();
	
	public Q4() {
		try (LineNumberReader lnReader = new LineNumberReader(new InputStreamReader(System.in))) {
			int numLines = Integer.parseInt(lnReader.readLine());
			for (int i = 0; i < numLines; i++) {
				String line = lnReader.readLine();
				StringTokenizer st = new StringTokenizer(line);
				peopleRequiredInSameGroup.add(new Rule(st.nextToken(), st.nextToken()));
			}
			numLines = Integer.parseInt(lnReader.readLine());
			for (int i = 0; i < numLines; i++) {
				String line = lnReader.readLine();
				StringTokenizer st = new StringTokenizer(line);
				peopleRequiredNotInSameGroup.add(new Rule(st.nextToken(), st.nextToken()));
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
		for (Rule pair : peopleRequiredInSameGroup) {
			sb.append("  " + pair + "\n");
		}
		sb.append("\n\nPeople Required Not in SameGroup:\n");
		for (Rule pair : peopleRequiredNotInSameGroup) {
			sb.append("  " + pair + "\n");
		}
		sb.append("\n\nGroups:\n");
		for (int i = 0; i < groups.size(); i++) {
			sb.append("  Group #" + (i + 1) + ": " + Arrays.toString(groups.get(i).toArray()) + "\n");
		}
		return sb.toString();
	}
	
	public int checkViolations() {
		int numOfRules = peopleRequiredInSameGroup.size() + peopleRequiredNotInSameGroup.size();
//		int k = 1;
		for (Set<String> group : groups) {
//			if (k % 1000 == 0)
//				System.out.println("Group #" + k + ", rule 1: " + peopleRequiredInSameGroup.size() + ", rule 2: " + peopleRequiredNotInSameGroup.size());
//			k++;
			checkGroupViolations(group);
		}
		return numOfRules - peopleRequiredInSameGroup.size() - peopleRequiredNotInSameGroup.size();
	}
	
	private void checkGroupViolations(Set<String> group) {
		List<Rule> rulesToBeRemoved = new ArrayList<>();
		for (int i = 0; i < peopleRequiredInSameGroup.size(); i++) {
//			if (group.contains(peopleRequiredInSameGroup.get(i).name1) ^ group.contains(peopleRequiredInSameGroup.get(i).name2)) {
			if (peopleRequiredInSameGroup.get(i).isViolate(group, true)) {
//				System.out.println(Arrays.toString(group.toArray()) + " violates same-group-rule: " + peopleRequiredInSameGroup.get(i));
				rulesToBeRemoved.add(peopleRequiredInSameGroup.get(i));
//				peopleRequiredInSameGroup.remove(i);
			}
		}
		for (Rule rule : rulesToBeRemoved) {
			peopleRequiredInSameGroup.remove(rule);
		}
		rulesToBeRemoved.clear();
		for (int i = 0; i < peopleRequiredNotInSameGroup.size(); i++) {
//			if (group.contains(peopleRequiredNotInSameGroup.get(i).name1) && group.contains(peopleRequiredNotInSameGroup.get(i).name2)) {
			if (peopleRequiredNotInSameGroup.get(i).isViolate(group, false)) {
//				System.out.println(Arrays.toString(group.toArray()) + " violates not-same-group-rule: " + Arrays.toString(peopleRequiredNotInSameGroup[i]));
				rulesToBeRemoved.add(peopleRequiredNotInSameGroup.get(i));
//				peopleRequiredNotInSameGroup.remove(i);
			}
		}
		for (Rule rule : rulesToBeRemoved) {
			peopleRequiredNotInSameGroup.remove(rule);
		}
	}

	public static void main(String[] args) {
		
		Q4 q4 = new Q4();
//		System.out.println(q4);
//		System.out.println("Start checking ...");
		System.out.println(q4.checkViolations());
		
	}

}
