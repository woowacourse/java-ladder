package laddergame.domain;

import static laddergame.messsages.ExceptionMessages.*;

import java.text.MessageFormat;

public class Person {
	private static final int MAX_NAME_LENGTH = 5;
	private final String name;

	public Person(final String name) {
		validateNameBlank(name);
		validateNameOverLength(name);
		this.name = name;
	}

	private void validateNameBlank(final String name) {
		if (name.isBlank()) {
			throw new IllegalArgumentException(PERSON_NAME_BLANK_EXCEPTION.getMessage());
		}
	}

	private void validateNameOverLength(final String name) {
		if (name.length() > MAX_NAME_LENGTH) {
			throw new IllegalArgumentException(
				MessageFormat.format(PERSON_NAME_OVER_LENGTH_EXCEPTION.getMessage(), MAX_NAME_LENGTH));
		}
	}
}
