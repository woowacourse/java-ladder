package domain;

import java.util.regex.Pattern;

public record Name(String value) {

	private static final Pattern NAME_REGEX = Pattern.compile("^[A-Za-z가-힣0-9]*$");
	private static final int MAX_NAME_LENGTH = 5;

	public Name {
		validateName(value);
	}

	private void validateName(String value) {
		validateNameLength(value);
		validateNamePattern(value);
	}

	private void validateNameLength(String value) {
		if (value == null || isNameLengthOutOfRange(value)) {
			throw new IllegalArgumentException("이름은 1자 이상 5자 이하여야 합니다.");
		}
	}

	private boolean isNameLengthOutOfRange(String value) {
		return value.isEmpty() || value.length() > MAX_NAME_LENGTH;
	}

	private void validateNamePattern(String value) {
		boolean isPatternMatches = NAME_REGEX.matcher(value).matches();
		if (!isPatternMatches) {
			throw new IllegalArgumentException("이름은 영문, 한글, 숫자로만 구성할 수 있습니다.");
		}
	}
}