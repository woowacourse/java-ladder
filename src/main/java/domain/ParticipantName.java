package domain;

public class ParticipantName {

	private static final int MIN_NAME_LENGTH = 1;
	private static final int MAX_NAME_LENGTH = 5;
	private static final String BLANK_PARTICIPANT_NAME_ERROR_MSG = "참가자의 이름은 공백일 수 없습니다.";
	private static final String NAME_LENGTH_ERROR_MSG = "참가자의 이름은 1글자 이상 5글자 이하여야 한다.";
	private final String name;

	public ParticipantName(final String name) {
		validateIsBlank(name);
		validateNameLength(name);
		this.name = name;
	}

	private void validateIsBlank(final String name) {
		if (name.isBlank()) {
			throw new IllegalArgumentException(BLANK_PARTICIPANT_NAME_ERROR_MSG);
		}
	}

	private void validateNameLength(final String name) {
		if (MIN_NAME_LENGTH > name.length() || name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException(NAME_LENGTH_ERROR_MSG);
		}
	}

	public String getName() {
		return name;
	}
}
