package domain;

import java.util.List;
import java.util.stream.Collectors;

public class People {
	private static final int MIN_PEOPLE_SIZE_INCLUSIVE = 2;
	private static final int MAX_PEOPLE_SIZE_INCLUSIVE = 10;

	private final List<Person> people;

	public People(List<String> names) {
		validate(names);
		this.people = names.stream()
			.map(Person::new)
			.collect(Collectors.toUnmodifiableList());
	}

	public int size() {
		return people.size();
	}

	private void validate(List<String> names) {
		if (names.size() < MIN_PEOPLE_SIZE_INCLUSIVE)
			throw new IllegalArgumentException("사람은 최소 두명 이상이어야 합니다");
		if (names.size() > MAX_PEOPLE_SIZE_INCLUSIVE)
			throw new IllegalArgumentException("사람은 최대 10명 이어야 합니다");
	}
}
