package domain;

import exception.Error;

public class Person {
	private final String name;

	public Person(String name) {
		validate(name);

		this.name = name.trim();
	}

	public String getName() {
		return this.name;
	}

	private void validate(String name) {
		name = name.trim();

		if (name.length() < 1 || name.length() > 5) {
			throw new IllegalArgumentException(Error.INVALID_NAME_LENGTH.getMessage());
		}
	}
}
