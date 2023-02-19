package view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
	public static final String FIRST_SECTION = "    |";
	public static final String SECTION = "|";
	public static final String ONE_STOOL = "-----";
	public static final String NO_STOOL = "     ";

	public void printResult(List<String> names, List<List<Boolean>> ladder) {
		System.out.println("\n실행결과\n");
		printNames(names);
		printLadder(ladder);
	}

	private static String makeLevelView(List<Boolean> level) {
		return FIRST_SECTION + level.stream()
			.map(OutputView::makeStoolView)
			.collect(Collectors.joining(SECTION)) + SECTION;
	}

	private static String makeStoolView(boolean stool) {
		if (stool)
			return ONE_STOOL;
		return NO_STOOL;
	}

	private void printNames(List<String> names) {
		names.stream()
			.map(name -> String.format("%6s", name))
			.forEach(System.out::print);
		System.out.println();
	}

	private void printLadder(List<List<Boolean>> ladder) {
		ladder.stream()
			.map(OutputView::makeLevelView)
			.forEach(System.out::println);
	}
}
