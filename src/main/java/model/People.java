package model;

import java.util.ArrayList;
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
        final List<Person> personGroup = new ArrayList<>(names.size());
        for (int column = 0; column < names.size(); column++) {
            final Person person = Person.from(names.get(column), column);
            personGroup.add(person);
        }
        return new People(personGroup);
    }

    public void climbDown(Ladder ladder) {
        personGroup.forEach(person -> person.climbDown(ladder));
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
