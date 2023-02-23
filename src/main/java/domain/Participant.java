package domain;

import domain.util.Display;

import java.util.HashMap;
import java.util.Map;

public class Participant implements Display {

	private static final String RIGHT_ALIGN_PLACEHOLDER = "%6s";
	private static final int MIN_NAME_LENGTH = 1;
	private static final int MAX_NAME_LENGTH = 5;
	private static final String BLANK_PARTICIPANT_NAME_ERROR_MSG = "참가자의 이름은 공백일 수 없습니다.";
	private static final String NAME_LENGTH_ERROR_MSG = "참가자의 이름은 1글자 이상 5글자 이하여야 한다.";
	private static final String CANNOT_FIND_PARTICIPANT_MESSAGE = "해당 이름의 참가자는 없습니다.";
	private final static Map<String, Participant> cachedParticipant = new HashMap<>();

	private final String name;

	private Participant(final String name) {
		this.name = name;
	}

	public static Participant from(final String name) {
		validateIsBlank(name);
		validateNameLength(name);
		if (!cachedParticipant.containsKey(name)) {
			cachedParticipant.put(name, new Participant(name));
		}
		return cachedParticipant.get(name);
	}

	private static void validateIsBlank(final String name) {
		if (name.isBlank()) {
			throw new IllegalArgumentException(BLANK_PARTICIPANT_NAME_ERROR_MSG);
		}
	}

	private static void validateNameLength(final String name) {
		if (MIN_NAME_LENGTH > name.length() || name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException(NAME_LENGTH_ERROR_MSG);
		}
	}

	public static void contains(String name) {
		if (!cachedParticipant.containsKey(name)) {
			throw new IllegalArgumentException(CANNOT_FIND_PARTICIPANT_MESSAGE);
		}
	}

	@Override
	public String format() {
		return String.format(RIGHT_ALIGN_PLACEHOLDER, name);
	}
}
