package domain;

import java.util.List;
import java.util.stream.Collectors;

import exception.Error;

public class People {
	private static final int MIN_PEOPLE_SIZE_INCLUSIVE = 2;
	private static final int MAX_PEOPLE_SIZE_INCLUSIVE = 10;

	private final List<Person> people;

	private People(List<Person> people) {
		this.people = people;
	}

	public static People from(List<String> names) {
		validate(names);

		return new People(names.stream()
			.map(Person::new)
			.collect(Collectors.toUnmodifiableList()));
	}

	private static void validate(List<String> names) {
		validateSize(names);
		validateDuplication(names);
	}

	private static void validateSize(List<String> names) {
		if (names.size() < MIN_PEOPLE_SIZE_INCLUSIVE)
			throw new IllegalArgumentException(Error.LACK_OF_PEOPLE.getMessage());
		if (names.size() > MAX_PEOPLE_SIZE_INCLUSIVE)
			throw new IllegalArgumentException(Error.TOO_MANY_PEOPLE.getMessage());
	}

	private static void validateDuplication(List<String> names) {
		int distinctCount = (int)names.stream()
			.map(String::trim)
			.distinct()
			.count();
		if (distinctCount != names.size())
			throw new IllegalArgumentException(Error.DUPLICATED_NAME.getMessage());
	}

	public int size() {
		return people.size();
	}

	public List<String> getNames() {
		return people.stream()
			.map(Person::getName)
			.collect(Collectors.toList());
	}
}
