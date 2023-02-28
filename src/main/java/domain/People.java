package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class People {
	private final List<Person> people;

	private People(List<Person> people) {
		this.people = people;
	}

	public static People from(List<String> names) {
		validate(names);
		List<Person> persons = new ArrayList<>();
		for (String name : names) {
			persons.add(new Person(name));
		}
		return new People(persons);
	}

	private static void validate(List<String> names) {
		validateSize(names);
		validateDuplication(names);
	}

	private static void validateSize(List<String> names) {
		int MIN_SIZE = 2;
		int MAX_SIZE = 10;
		if (names.size() < MIN_SIZE)
			throw new IllegalArgumentException(String.format("참여 인원은 %d ~ %d명이어야 합니다", MIN_SIZE, MAX_SIZE));
		if (names.size() > MAX_SIZE)
			throw new IllegalArgumentException(String.format("참여 인원은 %d ~ %d명이어야 합니다", MIN_SIZE, MAX_SIZE));
	}

	private static void validateDuplication(List<String> names) {
		int distinctCount = (int)names.stream()
			.map(String::trim)
			.distinct()
			.count();
		if (distinctCount != names.size())
			throw new IllegalArgumentException("사람 이름은 중복되지 않아야 합니다");
	}

	public List<String> getNames() {
		return people.stream()
			.map(Person::getName)
			.collect(Collectors.toList());
	}

	public void checkExistence(String sequence) {
		boolean isExist = getNames().contains(sequence);
		if (!isExist) {
			throw new IllegalArgumentException("대상은 참여자에 존재하지 않습니다");
		}
	}

	public int size() {
		return people.size();
	}
}
