package domain.end;

import java.util.Objects;

public class End {
	private static final int MIN_END_LENGTH = 1;
	private static final int MAX_NAME_LENGTH = 5;
	private static final String END_LENGTH_ERROR_MSG = "결과의 길이는 1글자 이상 5글자 이하여야 합니다.";
	private final String name;

	public End(final String name) {
		validateEndLength(name);
		this.name = name;
	}

	private void validateEndLength(final String name) {
		if (MIN_END_LENGTH > name.length() || MAX_NAME_LENGTH < name.length()) {
			throw new IllegalArgumentException(END_LENGTH_ERROR_MSG);
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
		if (!(o instanceof End)) {
			return false;
		}
		End end = (End)o;
		return Objects.equals(this.name, end.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(name);
	}
}
