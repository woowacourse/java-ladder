package view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
	public void printResult(List<String> names, List<List<Boolean>> ladder) {
		System.out.println("\n실행결과\n");
		printNames(names);
		printLadder(ladder);
	}

	private void printNames(List<String> names) {
		names.stream()
			.map(name -> String.format("%6s", name))
			.forEach(System.out::print);
		System.out.println();
	}

	private void printLadder(List<List<Boolean>> ladder) {
		String temp = ladder.stream()
			.map(level -> "    |" + level.stream()
				.map(stool -> {
					if (stool)
						return "-----";
					return "     ";
				})
				.collect(Collectors.joining("|")) + "|")
			.collect(Collectors.joining("\n"));
		System.out.println(temp);
	}
}
