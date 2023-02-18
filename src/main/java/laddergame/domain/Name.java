package laddergame.domain;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.regex.Pattern;

public class Name {
	private static final Pattern NAME_REGEX = Pattern.compile("([a-z]|[A-Z])+");
	private static final int MAX_NAME_LENGTH = 5;

	private final String value;

	public Name(final String name) {
		validate(name);
		this.value = name;
	}

	private void validate(final String value) {
		if (Objects.isNull(value)) {
			throw new IllegalArgumentException("이름은 null이 될 수 없습니다.");
		}
		if (value.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException(
					MessageFormat.format("이름은 {0}글자를 초과할 수 없습니다.", MAX_NAME_LENGTH));
		}
		if (!NAME_REGEX.matcher(value).matches()) {
			throw new IllegalArgumentException("이름은 영어로만 이루어져야합니다.");
		}
	}

	public String getValue() {
		return value;
	}
}
