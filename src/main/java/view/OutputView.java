package view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import domain.Ladder;
import domain.Line;
import domain.Participants;
import domain.util.Point;

public class OutputView {

	private final static String ABSENT_LINE = "     ";
	private final static String PRESENT_LINE = "-----";
	private final static String RIGHT_ALIGN_PLACEHOLDER = "%6s";
	private final static String LADDER_DELIMITER = "|";
	private final static String PREFIX = "     |";
	private final static String SUFFIX = "|";
	private final static String NEW_LINE = "\n";
	private final static String ERROR_PREFIX = "[ERROR] ";

	private final static Map<Boolean, String> LINE_MAP;

	static {
		LINE_MAP = Map.of(true, PRESENT_LINE, false, ABSENT_LINE);
	}

	public static void printResult(final Participants participants, final Ladder ladder) {
		System.out.println(getStringifiedNames(participants));
		System.out.println(getStringifiedLadder(ladder));
	}

	private static String getStringifiedNames(final Participants participants) {
		List<String> names = participants.getNames();
		StringBuilder stringifiedNames = new StringBuilder();
		for (String name : names) {
			stringifiedNames.append(String.format(RIGHT_ALIGN_PLACEHOLDER, name));
		}
		return stringifiedNames.toString();
	}

	private static String getStringifiedLadder(final Ladder ladder) {
		StringBuilder stringifiedLadder = new StringBuilder();
		List<Line> lines = ladder.getLines();
		for (Line line : lines) {
			List<Point> points = line.getPoints();
			String stringifiedLine = getStringifiedLine(points);
			stringifiedLadder.append(stringifiedLine).append(NEW_LINE);
		}
		return stringifiedLadder.toString();
	}

	private static String getStringifiedLine(final List<Point> points) {
		return points.stream()
			.map(point -> LINE_MAP.get(point.isPresent()))
			.collect(Collectors.joining(LADDER_DELIMITER, PREFIX, SUFFIX));
	}

	public static void printError(final String errorMsg) {
		System.out.println(ERROR_PREFIX + errorMsg);
	}
}
