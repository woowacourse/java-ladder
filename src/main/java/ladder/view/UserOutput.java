package ladder.view;

public enum UserOutput {
	LADDER_STEP("-----"),
	LADDER_SPACE("     "),
	LADDER_LINE("|"),
	DEMAND_PLAYER_NAMES("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),
	DEMAND_LADDER_HEIGHT("최대 사다리 높이는 얼마인가요?"),
	DEMAND_GAME_RESULTS("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)"),
	DEMAND_PLAYER_NAME_FOR_RESULT("결과를 보고 싶은 사람은? (exit 입력시 게임 종료.)"),
	PRINT_FORM("%-6s"),
	REGEX_FOR_NUMBER("[0-9][1-9]*");

	private final String outputMessage;

	UserOutput(String outputMessage) {
		this.outputMessage = outputMessage;
	}

	public String getOutputMessage() {
		return outputMessage;
	}
}
