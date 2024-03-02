package domain.prize;

public class Prize {

	private static final int MAX_NAME_LENGTH = 5;

	private final String name;

	public Prize(String name) {
		validateNameLength(name);
		this.name = name;
	}

	private void validateNameLength(String name) {
		if (name.isBlank() || name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException("이름은 1자 이상 5자 이하여야 합니다.");
		}
	}

	public String getName() {
		return name;
	}
}
