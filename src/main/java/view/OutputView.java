package view;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import domain.util.LinePointsGenerator;

public class OutputView {

	private final static String ABSENT_LINE = "     ";
	private final static String PRESENT_LINE = "-----";
	private final static String LADDER_DELIMITER = "|";
	private final static Map<Boolean, String> LINE_MAP;

	static {
		LINE_MAP = Map.of(true, PRESENT_LINE, false, ABSENT_LINE);
	}

	public static void printResult(List<String> names, List<List<Boolean>> ladderPoints) {
		StringBuilder sb = new StringBuilder();
		for (String name : names) {
			sb.append(String.format("%6s", name));
		}

		StringBuilder lineBuilder = new StringBuilder();

		for (List<Boolean> linePoints : ladderPoints) {
			lineBuilder.append(ABSENT_LINE);
			String collectedLine = linePoints.stream()
				.map(point -> LINE_MAP.get(point))
				.collect(Collectors.joining(LADDER_DELIMITER, LADDER_DELIMITER, LADDER_DELIMITER));
			lineBuilder.append(collectedLine).append("\n");
		}
		System.out.println(sb);
		System.out.println(lineBuilder);
	}
}
