package model;

import java.util.List;

public class People {
    private static final int MIN_PERSON_COUNT = 2;

    private final List<Person> personGroup;

    private People(List<Person> personGroup) {
        validatePersonCount(personGroup.size());
        this.personGroup = personGroup;
    }

    private void validatePersonCount(int personCount) {
        if (personCount < MIN_PERSON_COUNT) {
            throw new IllegalArgumentException("사람은 최소 2명 참가해야 합니다.");
        }
    }

    public static People from(List<String> names) {
        List<Person> personGroup = names.stream()
                .map(Person::new)
                .toList();
        return new People(personGroup);
    }


}
