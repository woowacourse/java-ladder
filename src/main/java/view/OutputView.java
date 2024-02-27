package view;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import domain.Bar;
import domain.FloorConnectionStatusDto;

public class OutputView {

	private static final int LADDER_WIDTH_UNIT = 5;
	private static final String VERTICAL_LADDER_CHARACTER = "|";
	private static final String HORIZONTAL_LADDER_CHARACTER = "-";
	private static final String EMPTY_LADDER_CHARACTER = " ";
	private static final String LADDER_PREFIX_SPACES = "    ";
	private static final String NAME_PRINT_FORMAT = "%" + LADDER_WIDTH_UNIT + "s";
	private static final String COLON_WITH_SPACE = " : ";

	public void printReadNames() {
		System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
	}

	public void printReadPrizes() {
		System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
	}

	public void printReadLadderHeight() {
		System.out.println("최대 사다리 높이는 몇 개인가요?");
	}

	public void printReadPlayer() {
		System.out.println("결과를 보고 싶은 사람은?");
	}

	public void printResultMessage() {
		System.out.println("사다리 결과" + System.lineSeparator());
	}

	public void printNames(List<String> names) {
		StringJoiner joiner = new StringJoiner(" ");

		names.stream()
			.map(this::formatName)
			.forEach(joiner::add);

		System.out.println(joiner);
	}

	public void printLadder(List<FloorConnectionStatusDto> statuses) {
		statuses.stream()
			.map(FloorConnectionStatusDto::connections)
			.forEach(this::printHorizontalLine);
	}

	public void printErrorMessage(String message) {
		System.out.println("[ERROR] " + message + System.lineSeparator());
	}

	private void printHorizontalLine(List<Boolean> connections) {
		StringBuilder builder = new StringBuilder();

		builder.append(LADDER_PREFIX_SPACES);
		connections.forEach(connection ->
			builder.append(VERTICAL_LADDER_CHARACTER)
				.append(getHorizontalLadderCharacter(connection))
		);

		System.out.println(builder);
	}

	private String getHorizontalLadderCharacter(Boolean connection) {
		if (connection) {
			return HORIZONTAL_LADDER_CHARACTER.repeat(LADDER_WIDTH_UNIT);
		}
		return EMPTY_LADDER_CHARACTER.repeat(LADDER_WIDTH_UNIT);
	}

	private String formatName(String name) {
		return String.format(NAME_PRINT_FORMAT, name);
	}

	public void printAllPlayersResult(Map<String, String> result) {
		printGameResult();
		result.forEach((name, prize) -> System.out.println(name + COLON_WITH_SPACE + prize));
	}

	public void printOnePlayerResult(String name) {
		printGameResult();
		System.out.println(name);
	}

	private void printGameResult() {
		System.out.println("실행 결과");
	}

	public void printEmptyLine() {
		System.out.println();
	}
}