package laddergame.domain;

import java.text.MessageFormat;

import static laddergame.messsages.ExceptionMessages.*;

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
			throw new IllegalArgumentException(NAME_NULL_EXCEPTION.getMessage());
		}
	}

	private void validateBlank(final String value) {
		if (value.isBlank()) {
			throw new IllegalArgumentException(NAME_BLANK_EXCEPTION.getMessage());
		}
	}

	private void validateOverLength(final String value) {
		if (value.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException(
				MessageFormat.format(NAME_OVER_LENGTH_EXCEPTION.getMessage(), MAX_NAME_LENGTH));
		}
	}

	public String getValue() {
		return value;
	}
}
