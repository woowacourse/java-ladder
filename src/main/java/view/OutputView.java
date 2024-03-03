package view;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import dto.FloorConnectionStatusDto;

public class OutputView {

	private static final int LADDER_WIDTH_UNIT = 5;
	private static final String VERTICAL_LADDER_CHARACTER = "|";
	private static final String HORIZONTAL_LADDER_CHARACTER = "-";
	private static final String EMPTY_LADDER_CHARACTER = " ";
	private static final String LADDER_PREFIX_SPACES = "    ";
	private static final String NAME_PRINT_FORMAT = "%" + LADDER_WIDTH_UNIT + "s";
	private static final String COLON_WITH_SPACE = " : ";

	public void printRequestNamesMessage() {
		System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
	}

	public void printRequestPrizesMessage() {
		System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
	}

	public void printRequestLadderHeightMessage() {
		System.out.println("최대 사다리 높이는 몇 개인가요?");
	}

	public void printRequestPlayerToGetPrizeMessage() {
		System.out.println("결과를 보고 싶은 사람은?");
	}

	public void printErrorMessage(String message) {
		System.out.println("[ERROR] " + message + System.lineSeparator());
	}

	public void printCurrentLadder(
		List<String> playerNames,
		List<FloorConnectionStatusDto> ladderConnectionStatus,
		List<String> prizeNames
	) {
		printLadderResultPrefix();
		printNames(playerNames);
		printLadder(ladderConnectionStatus);
		printNames(prizeNames);
		printEmptyLine();
	}

	public void printAllPlayerResults(Map<String, String> result) {
		printGameResultPrefix();
		result.forEach((name, prize) -> System.out.println(name + COLON_WITH_SPACE + prize));
	}

	public void printOnePlayerResult(String name) {
		printGameResultPrefix();
		System.out.println(name);
	}

	public void printEmptyLine() {
		System.out.println();
	}

	private void printLadderResultPrefix() {
		System.out.println("사다리 결과" + System.lineSeparator());
	}

	private void printNames(List<String> names) {
		StringJoiner joiner = new StringJoiner(" ");

		names.stream()
			.map(this::formatName)
			.forEach(joiner::add);

		System.out.println(joiner);
	}

	private String formatName(String name) {
		return String.format(NAME_PRINT_FORMAT, name);
	}

	private void printLadder(List<FloorConnectionStatusDto> ladderConnectionStatus) {
		ladderConnectionStatus.stream()
			.map(FloorConnectionStatusDto::connections)
			.forEach(this::printOneFloor);
	}

	private void printOneFloor(List<Boolean> connections) {
		StringBuilder builder = new StringBuilder();

		builder.append(LADDER_PREFIX_SPACES);
		connections.forEach(connection ->
			builder.append(VERTICAL_LADDER_CHARACTER)
				.append(getConnectionCharacter(connection))
		);

		System.out.println(builder);
	}

	private String getConnectionCharacter(Boolean connection) {
		if (connection) {
			return HORIZONTAL_LADDER_CHARACTER.repeat(LADDER_WIDTH_UNIT);
		}
		return EMPTY_LADDER_CHARACTER.repeat(LADDER_WIDTH_UNIT);
	}

	private void printGameResultPrefix() {
		System.out.println("실행 결과");
	}
}
