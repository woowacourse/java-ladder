package laddergame.domain;

import java.text.MessageFormat;

import static laddergame.messsages.ExceptionMessages.PERSON_NAME_BLANK_EXCEPTION;
import static laddergame.messsages.ExceptionMessages.PERSON_NAME_OVER_LENGTH_EXCEPTION;

public class Name {
	private static final int MAX_NAME_LENGTH = 5;
	private final String value;

	public Name(final String value) {
		validateNull(value);
		validateBlank(value);
		validateOverLength(value);
		this.value = value;
	}

	private void validateNull(final String value) {
		if (value == null) {
			throw new IllegalArgumentException();
		}
	}

	private void validateBlank(final String value) {
		if (value.isBlank()) {
			throw new IllegalArgumentException(PERSON_NAME_BLANK_EXCEPTION.getMessage());
		}
	}

	private void validateOverLength(final String value) {
		if (value.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException(
				MessageFormat.format(PERSON_NAME_OVER_LENGTH_EXCEPTION.getMessage(), MAX_NAME_LENGTH));
		}
	}

	public String getValue() {
		return value;
	}
}
