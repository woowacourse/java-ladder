package model.people;

import java.util.List;
import model.Index;

public class People {
    private static final int MIN_PERSON_COUNT = 2;

    private final List<Person> personGroup;

    private People(final List<Person> personGroup) {
        validateMinimumPersonCount(personGroup.size());
        validateDuplicatePerson(personGroup);
        this.personGroup = personGroup;
    }

    public static People from(final List<String> names) {
        final List<Person> personGroup = names.stream()
                .map(Person::new)
                .toList();
        return new People(personGroup);
    }

    private void validateMinimumPersonCount(final int rawCount) {
        if (rawCount < MIN_PERSON_COUNT) {
            throw new IllegalArgumentException("참여 인원은 최소 2여야 합니다.");
        }
    }

    private void validateDuplicatePerson(final List<Person> personGroup) {
        int uniquePersonCount = (int) personGroup.stream()
                .distinct()
                .count();
        if (personGroup.size() != uniquePersonCount) {
            throw new IllegalArgumentException("여자들의 이름 중 중복되는 이름은 존재할 수 없습니다.");
        }
    }

    public Person findBy(Index index) {
        return personGroup.get(index.getIndex());
    }

    public List<String> getNames() {
        return personGroup.stream()
                .map(Person::getName)
                .toList();
    }

    public int findPeopleSize() {
        return personGroup.size();
    }
}
