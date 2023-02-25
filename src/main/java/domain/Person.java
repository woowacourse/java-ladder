package domain;

public class Person {
	private final String name;

	public Person(String name) {
		validate(name);
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	private void validate(String name) {
		name = name.strip();
		int MIN_LETTER = 1;
		int MAX_LETTER = 5;
		if (name.length() < MIN_LETTER || name.length() > MAX_LETTER) {
			throw new IllegalArgumentException(String.format("이름은 %d ~ %d글자만 가능합니다", MIN_LETTER, MAX_LETTER));
		}
	}
}
