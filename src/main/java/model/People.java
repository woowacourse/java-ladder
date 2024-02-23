package model;

import java.util.List;

public class People {
    private static final int MIN_PERSON_COUNT = 2;

    private final List<Person> personGroup;

    private People(final List<Person> personGroup) {
        validatePersonCount(personGroup.size());
        this.personGroup = personGroup;
    }

    private void validatePersonCount(final int personCount) {
        if (personCount < MIN_PERSON_COUNT) {
            throw new IllegalArgumentException("사람은 최소 2명 참가해야 합니다.");
        }
    }

    public static People from(final List<String> names) {
        final List<Person> personGroup = names.stream()
                .map(Person::from)
                .toList();
        return new People(personGroup);
    }

    public List<String> getNames() {
        return personGroup.stream()
                .map(Person::getName)
                .toList();
    }

    public int getPersonCount() {
        return personGroup.size();
    }
}
