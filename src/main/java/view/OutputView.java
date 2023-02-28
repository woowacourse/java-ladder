package view;

import java.util.List;
import java.util.Map;

public class OutputView {
	public static final String FIRST_SECTION = "    |";
	public static final String SECTION = "|";
	public static final String ONE_STOOL = "-----";
	public static final String NO_STOOL = "     ";

	private static String makeLevelView(List<Boolean> level) {
		StringBuilder view = new StringBuilder(FIRST_SECTION);
		for (Boolean stool : level) {
			view.append(makeStoolView(stool)).append(SECTION);
		}
		return view.toString();
	}

	private static String makeStoolView(boolean stool) {
		if (stool)
			return ONE_STOOL;
		return NO_STOOL;
	}

	public void printResult(List<String> names, List<List<Boolean>> ladder, List<String> rewards) {
		System.out.println("\n실행결과\n");
		printNames(names);
		printLadder(ladder);
		printRewards(rewards);
	}

	private void printNames(List<String> names) {
		for (String name : names) {
			System.out.printf("%6s", name);
		}
		System.out.println();
	}

	private void printLadder(List<List<Boolean>> ladder) {
		ladder.stream()
			.map(OutputView::makeLevelView)
			.forEach(System.out::println);
	}

	private void printRewards(List<String> rewards) {
		for (String reward : rewards) {
			System.out.printf("%6s", reward);
		}
		System.out.println();
	}

	public void printWanted(String target, Map<String, String> resultTable) {
		System.out.println("\n실행결과");
		System.out.println(resultTable.get(target));
	}

	public void printAll(Map<String, String> resultTable) {
		System.out.println("\n실행결과");
		for (String name : resultTable.keySet()) {
			System.out.println(name + " : " + resultTable.get(name));
		}
	}
}
