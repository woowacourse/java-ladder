package view;

import domain.util.Point;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

	private final static String ABSENT_LINE = "     ";
	private final static String PRESENT_LINE = "-----";
	private final static String RIGHT_ALIGN_PLACEHOLDER = "%6s";
	private final static String LADDER_DELIMITER = "|";
	private final static String PREFIX = "|";
	private final static String SUFFIX = "|";
	private final static String NEW_LINE = "\n";
	private final static String ERROR_PREFIX = "[ERROR] ";

	private final static Map<Boolean, String> LINE_MAP = Map.of(true, PRESENT_LINE, false, ABSENT_LINE);

	public static void printResult(List<String> names, List<List<Point>> ladderPoints) {
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

	private static String getStringifiedLadder(List<List<Point>> ladderPoints) {
		StringBuilder lineBuilder = new StringBuilder();
		for (List<Point> linePoints : ladderPoints) {
			lineBuilder.append(ABSENT_LINE);
			String collectedLine = linePoints.stream()
				.map(point -> LINE_MAP.get(point.isPresent()))
				.collect(Collectors.joining(LADDER_DELIMITER, PREFIX, SUFFIX));
			lineBuilder.append(collectedLine).append(NEW_LINE);
		}
		return lineBuilder.toString();
	}

	public static void printError(String errorMsg) {
		System.out.println(ERROR_PREFIX + errorMsg);
	}
}
