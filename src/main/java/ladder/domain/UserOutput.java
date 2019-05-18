package ladder.domain;

public enum UserOutput {
	LADDER_STEP("-----"),
	LADDER_SPACE("     "),
	LADDER_LINE("|"),
	DEMAND_PLAYER_NAMES("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),
	DEMAND_LADDER_HEIGHT("최대 사다리 높이는 얼마인가요?"),
	DEMAND_GAME_RESULTS("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)"),
	DEMAND_PLAYER_NAME_FOR_RESULT("결과를 보고 싶은 사람은?"),
	VIOLATE_PLAYER_NAMES("참가자 이름을 5글자 이내로 입력해주세요."),
	VIOLATE_PLAYER_NAME_ALL("참가자 이름에 all은 들어갈 수 없습니다."),
	VIOLATE_PLAYER_OVERLAP_NAMES("참가자 이름 중 중복되는 이름이 있습니다."),
	VIOLATE_NUMBER_OF_PLAYERS("참가자의 수는 2명 이상이어야 합니다."),
	VIOLATE_LADDER_HEIGHT("사다리의 높이를 숫자로 입력해주세요."),
	VIOLATE_PLAYER_NAME("잘못된 입력입니다."),
	VIOLATE_GAME_RESULTS("참가자 수와 실행 결과의 수가 다릅니다."),
	PRINT_FORM("%-6s"),
	PRINT_ALL_PLAYER("all");

	private final String outputMessage;

	UserOutput(String outputMessage) {
		this.outputMessage = outputMessage;
	}

	public String getOutputMessage() {
		return outputMessage;
	}
}
