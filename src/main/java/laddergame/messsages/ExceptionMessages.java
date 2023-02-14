package laddergame.messsages;

public enum ExceptionMessages {
	PERSON_NAME_BLANK_EXCEPTION("사람 이름은 공백이 될 수 없습니다."),
	PERSON_NAME_OVER_LENGTH_EXCEPTION("사람 이름은 {0}글자를 초과할 수 없습니다.");

	private final String message;

	ExceptionMessages(final String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
