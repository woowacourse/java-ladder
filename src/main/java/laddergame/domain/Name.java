package laddergame.domain;

import java.text.MessageFormat;
import java.util.regex.Pattern;

import static laddergame.messsages.ExceptionMessages.*;

public class Name {
	private static final Pattern NAME_REGEX = Pattern.compile("([a-z]|[A-Z])*");
	private static final int MAX_NAME_LENGTH = 5;
	private final String value;

	public Name(final String value) {
		validateNotNull(value);
		validateMatchesPattern(value);
		validateNotOverLength(value);
		this.value = value;
	}

	private void validateMatchesPattern(final String value) {
		if (!NAME_REGEX.matcher(value).matches()) {
			throw new IllegalArgumentException();
		}
	}

	private void validateNotNull(final String value) {
		if (value == null) {
			throw new IllegalArgumentException(NAME_NULL_EXCEPTION.getMessage());
		}
	}

	private void validateNotOverLength(final String value) {
		if (value.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException(
				MessageFormat.format(NAME_OVER_LENGTH_EXCEPTION.getMessage(), MAX_NAME_LENGTH));
		}
	}

	public String getValue() {
		return value;
	}
}
