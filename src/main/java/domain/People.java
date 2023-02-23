package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class People {

    public static final int MIN_PERSON_COUNT = 2;
    public static final String NOT_ENOUGH_PEOPLE_FORMAT = "사람은 %d명 이상이어야 합니다.";
    public static final String DUPLICATE_NAME_MSG = "중복된 이름이 존재합니다";

    private final List<Person> people;

    public People(List<Person> people) {
        validatePeopleCount(people);
        validateDuplicate(people);
        this.people = people;
    }

    private void validatePeopleCount(List<Person> people) {
        if (people.size() < MIN_PERSON_COUNT) {
            throw new IllegalArgumentException(
                String.format(NOT_ENOUGH_PEOPLE_FORMAT, MIN_PERSON_COUNT));
        }
    }

    private void validateDuplicate(List<Person> people) {
        long noDuplicateCount = people.stream()
            .map(Person::getName)
            .distinct()
            .count();

        if (people.size() != noDuplicateCount) {
            throw new IllegalArgumentException(DUPLICATE_NAME_MSG);
        }
    }

    public List<String> getNames() {
        return people.stream()
            .map(Person::getName)
            .collect(Collectors.toList());
    }

    public int getCount() {
        return people.size();
    }

    public List<Person> getPeople() {
        return new ArrayList<>(people);
    }

    public Person searchByName(String name) {
        return people.stream()
            .filter(p -> p.getName().equals(name))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이름입니다"));
    }
}
