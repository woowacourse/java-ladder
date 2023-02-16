package laddergame.messsages;

public enum ExceptionMessages {
	NAME_NULL_EXCEPTION("이름은 null이 될 수 없습니다."),
	NAME_BLANK_EXCEPTION("이름은 공백이 될 수 없습니다."),
	NAME_OVER_LENGTH_EXCEPTION("이름은 {0}글자를 초과할 수 없습니다."),
	PARTICIPANTS_NULL_EXCEPTION("참여자 이름 목록은 null이 될 수 없습니다."),
	PARTICIPANTS_EMPTY_EXCEPTION("참여자 이름 목록은 비어있을 수 없습니다."),
	LINE_POINTS_EMPTY_EXCEPTION("boolean 리스트는 비어있을 수 없습니다."),
	LINE_POINTS_BOTH_TRUE_EXCEPTION("사다리의 가로 라인은 겹칠 수 없습니다."),
	LINE_CREATOR_BOOLEAN_GENERATOR_NULL_EXCEPTION("boolean generator는 null이 될 수 없습니다."),
	LINE_CREATOR_ILLEGAL_LENGTH_EXCEPTION("길이는 양수여야합니다."),
	LADDER_PARTICIPANTS_NULL_EXCEPTION("참여자는 null이 될 수 없습니다."),
	LADDER_HEIGHT_NULL_EXCEPTION("높이는 null이 될 수 없습니다."),
	HEIGHT_ILLEGAL_VALUE_EXCEPTION("높이는 양수여야합니다."),
	NAME_NOT_MACHE_EXCEPTION("이름은 1자 이상의 영문만 들어올 수 있습니다.");


	private final String message;

	ExceptionMessages(final String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
