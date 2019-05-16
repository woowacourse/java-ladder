package ladder.domain;

public enum UserOutput {
	DEMAND_PLAYER_NAMES("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),
	DEMAND_LADDER_HEIGHT("최대 사다리 높이는 몇 개인가요?"),
	LADDER_STEP("-----"),
	LADDER_SPACE("     "),
	LADDER_LINE("|"),
	VIOLATE_PLAYER_NAMES("참가자 이름이 5글자를 초과하였습니다."),
	VIOLATE_LADDER_HEIGHT("사다리의 높이를 숫자로 입력해주세요."),
	VIOLATE_PLAYER_NAME("잘못된 입력입니다.");


	private final String outputMessage;

	UserOutput(String outputMessage) {
		this.outputMessage = outputMessage;
	}

	public String getOutputMessage() {
		return outputMessage;
	}
}
