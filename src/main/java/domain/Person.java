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
		name = name.trim();
		if (name.length() < 1 || name.length() > 5) {
			throw new IllegalArgumentException("이름은 1 ~ 5글자만 가능합니다");
		}
	}
}
