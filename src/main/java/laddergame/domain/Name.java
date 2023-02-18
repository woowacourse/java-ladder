package laddergame.domain;

import java.text.MessageFormat;
import java.util.regex.Pattern;

public class Name {
	private static final Pattern NAME_REGEX = Pattern.compile("([a-z]|[A-Z])+");
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
			throw new IllegalArgumentException("이름은 공백이 될 수 없습니다.");
		}
	}

	private void validateNotNull(final String value) {
		if (value == null) {
			throw new IllegalArgumentException("이름은 null이 될 수 없습니다.");
		}
	}

	private void validateNotOverLength(final String value) {
		if (value.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException(
				MessageFormat.format("이름은 {0}글자를 초과할 수 없습니다.", MAX_NAME_LENGTH));
		}
	}

	public String getValue() {
		return value;
	}
}
