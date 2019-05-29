package ladder.domain;

public enum ExceptionOutput {
	VIOLATE_PLAYER_NAMES("참가자 이름을 5글자 이내로 입력해주세요."),
	VIOLATE_PLAYER_NAME_ALL("참가자 이름에 all은 들어갈 수 없습니다."),
	VIOLATE_PLAYER_OVERLAP_NAMES("참가자 이름 중 중복되는 이름이 있습니다."),
	VIOLATE_NUMBER_OF_PLAYERS("참가자의 수는 2명 이상이어야 합니다."),
	VIOLATE_LADDER_HEIGHT("사다리의 높이를 숫자로 입력해주세요."),
	VIOLATE_LADDER_HEIGHT_LESS_THAN_TWO("사다리의 숫자는 2 이상이어야 합니다."),
	VIOLATE_PLAYER_NAME_AND_REWARD_NAME("잘못된 입력입니다."),
	VIOLATE_GAME_RESULTS("참가자 수와 실행 결과의 수가 다릅니다."),
	VIOLATE_GAME_REWARD("실행 결과를 다시 입력해주세요."),
	VIOLATE_POINTS("잘못된 포인트 값 입니다."),
	VIOLATE_INDEX("잘못된 인덱스 값 입니다.");

	private final String outputMessage;

	ExceptionOutput(String outputMessage) {
		this.outputMessage = outputMessage;
	}

	public String getOutputMessage() {
		return outputMessage;
	}
}
