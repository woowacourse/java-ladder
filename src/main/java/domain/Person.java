package domain;

import exception.Error;

public class Person {
	private static final int MIN_NAME_LENGTH_INCLUSIVE = 1;
	private static final int MAX_NAME_LENGTH_INCLUSIVE = 5;

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

		if (name.length() < MIN_NAME_LENGTH_INCLUSIVE || name.length() > MAX_NAME_LENGTH_INCLUSIVE) {
			throw new IllegalArgumentException(Error.INVALID_NAME_LENGTH.getMessage());
		}
	}
}
