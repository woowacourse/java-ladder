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
	private final static String RIGHT_ALIGN_PLACEHOLDER = "%6s";
	private final static String LADDER_DELIMITER = "|";
	private final static Map<Boolean, String> LINE_MAP;

	static {
		LINE_MAP = Map.of(true, PRESENT_LINE, false, ABSENT_LINE);
	}

	public static void printResult(List<String> names, List<List<Boolean>> ladderPoints) {
		String stringifiedNames = getStringifiedNames(names);
		String stringifiedLadder = getStringifiedLadder(ladderPoints);
		System.out.println(stringifiedNames);
		System.out.println(stringifiedLadder);
	}

	private static String getStringifiedNames(List<String> names) {
		StringBuilder sb = new StringBuilder();
		for (String name : names) {
			sb.append(String.format(RIGHT_ALIGN_PLACEHOLDER, name));
		}
		return sb.toString();
	}

	private static String getStringifiedLadder(List<List<Boolean>> ladderPoints) {
		StringBuilder lineBuilder = new StringBuilder();
		for (List<Boolean> linePoints : ladderPoints) {
			lineBuilder.append(ABSENT_LINE);
			String collectedLine = linePoints.stream()
				.map(point -> LINE_MAP.get(point))
				.collect(Collectors.joining(LADDER_DELIMITER, PREFIX, SUFFIX));
			lineBuilder.append(collectedLine).append(NEW_LINE);
		}
		return lineBuilder.toString();
	}
}
