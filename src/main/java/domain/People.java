package domain;

import exception.Error;

import java.util.List;
import java.util.stream.Collectors;

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
        if (names.size() < MIN_PEOPLE_SIZE_INCLUSIVE || names.size() > MAX_PEOPLE_SIZE_INCLUSIVE) {
            throw new IllegalArgumentException(Error.INVALID_PEOPLE_SIZE.getMessage());
        }
    }

    private static void validateDuplication(List<String> names) {
        int distinctCount = (int) names.stream()
                .map(String::trim)
                .distinct()
                .count();

        if (distinctCount != names.size()) {
            throw new IllegalArgumentException(Error.DUPLICATED_NAME.getMessage());
        }
    }

    public int getPosition(String name) {
        final int NOT_EXIST = -1;

        int position = getNames().indexOf(name);
        if (position == NOT_EXIST) {
            throw new IllegalArgumentException(Error.NAME_IS_NOT_EXIST.getMessage());
        }

        return position;
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
