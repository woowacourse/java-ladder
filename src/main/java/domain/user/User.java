package domain.user;

import java.util.List;
import java.util.Objects;

public class User {
	private static final int MIN_NAME_LENGTH = 1;
	private static final int MAX_NAME_LENGTH = 5;
	private static final String BLANK_USER_NAME_ERROR_MSG = "참가자의 이름은 공백일 수 없습니다.";
	private static final String NAME_LENGTH_ERROR_MSG = "참가자의 이름은 1글자 이상 5글자 이하여야 합니다.";
	private static final String INVALID_NAME_ERROR_MSG = "사용할 수 없는 이름이 포함되어 있습니다.";
	private static final List<String> INVALID_NAMES = List.of("all");
	private final String name;

	public User(final String name) {
		validateIsBlank(name);
		validateNameLength(name);
		validateInInvalid(name);
		this.name = name;
	}

	private void validateIsBlank(final String name) {
		if (name.isBlank()) {
			throw new IllegalArgumentException(BLANK_USER_NAME_ERROR_MSG);
		}
	}

	private void validateNameLength(final String name) {
		if (MIN_NAME_LENGTH > name.length() || MAX_NAME_LENGTH < name.length()) {
			throw new IllegalArgumentException(NAME_LENGTH_ERROR_MSG);
		}
	}

	private void validateInInvalid(final String name) {
		if (INVALID_NAMES.contains(name)) {
			throw new IllegalArgumentException(INVALID_NAME_ERROR_MSG);
		}
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof User)) {
			return false;
		}
		User user = (User)o;
		return Objects.equals(this.name, user.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(name);
	}
}
