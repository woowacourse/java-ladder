package view;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import domain.end.End;
import domain.end.Ends;
import domain.ladder.Ladder;
import domain.ladder.Line;
import domain.user.User;
import domain.user.Users;
import domain.ladder.Point;

public class OutputView {

	private final static String ABSENT_LINE = "     ";
	private final static String PRESENT_LINE = "-----";
	private final static String LADDER_OUTPUT_MSG = "사다리 결과";
	private final static String RIGHT_ALIGN_PLACEHOLDER = "%6s";
	private final static String LADDER_DELIMITER = "|";
	private final static String PREFIX = "     |";
	private final static String SUFFIX = "|";
	private final static String RESULT_MSG = "실행 결과";
	private final static String NEW_LINE = "\n";
	private final static String ERROR_PREFIX = "[ERROR] ";

	private final static Map<Boolean, String> LINE_MAP;

	static {
		LINE_MAP = Map.of(true, PRESENT_LINE, false, ABSENT_LINE);
	}

	public static void printLadder(final Users users, final Ladder ladder, final Ends ends) {
		System.out.println(LADDER_OUTPUT_MSG);
		System.out.println(getStringifiedNames(users));
		System.out.println(getStringifiedLadder(ladder));
		System.out.println(getStringifiedEnds(ends) + NEW_LINE);
	}

	private static String getStringifiedNames(final Users users) {
		List<User> userList = users.getUsers();
		StringBuilder stringifiedNames = new StringBuilder();
		for (User user : userList) {
			stringifiedNames.append(String.format(RIGHT_ALIGN_PLACEHOLDER, user.getName()));
		}
		return stringifiedNames.toString();
	}

	private static String getStringifiedLadder(final Ladder ladder) {
		StringJoiner stringifiedLadder = new StringJoiner(NEW_LINE);
		List<Line> lines = ladder.getLines();
		for (Line line : lines) {
			List<Point> points = line.getPoints();
			String stringifiedLine = getStringifiedLine(points);
			stringifiedLadder.add(stringifiedLine);
		}
		return stringifiedLadder.toString();
	}

	private static String getStringifiedLine(final List<Point> points) {
		return points.stream()
			.map(point -> LINE_MAP.get(point.isPresent()))
			.collect(Collectors.joining(LADDER_DELIMITER, PREFIX, SUFFIX));
	}

	private static String getStringifiedEnds(final Ends ends) {
		List<End> endList = ends.getEnds();
		StringBuilder stringifiedNames = new StringBuilder();
		for (End end : endList) {
			stringifiedNames.append(String.format(RIGHT_ALIGN_PLACEHOLDER, end.getName()));
		}
		return stringifiedNames.toString();
	}

	public static void printResult(final Map<User, End> result) {
		System.out.println(RESULT_MSG);
		if (result.size() == 1) {
			System.out.println(getSingleStringifiedResult(result));
			return;
		}
		System.out.println(getStringifiedResult(result) + NEW_LINE);
	}

	private static String getSingleStringifiedResult(final Map<User, End> result) {
		String name = "";
		for (User user : result.keySet()) {
			name = result.get(user).getName();
		}
		return name;
	}

	private static String getStringifiedResult(final Map<User, End> result) {
		StringJoiner joiner = new StringJoiner(NEW_LINE);
		Set<User> users = result.keySet();
		for (User user : users) {
			joiner.add(user.getName() + " : " + result.get(user).getName());
		}
		return joiner.toString();
	}

	public static void printError(final String errorMsg) {
		System.out.println(ERROR_PREFIX + errorMsg);
	}
}
