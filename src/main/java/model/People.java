package model;

import java.util.ArrayList;
import java.util.List;

public class People {
    private static final int MIN_PERSON_COUNT = 2;

    private final List<Person> personGroup;

    public People(final List<Person> personGroup) {
        validatePersonCount(personGroup.size());
        validateDuplicatedPersonNames(personGroup);
        this.personGroup = personGroup;
    }

    private void validatePersonCount(final int personCount) {
        if (personCount < MIN_PERSON_COUNT) {
            throw new IllegalArgumentException("사람은 최소 2명 참가해야 합니다.");
        }
    }

    private void validateDuplicatedPersonNames(final List<Person> personGroup) {
        long personCount = personGroup.stream()
                .map(Person::getPersonName)
                .distinct()
                .count();
        if (personCount != personGroup.size()) {
            throw new IllegalArgumentException("중복된 사람이름은 존재할 수 없습니다.");
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

    public boolean contains(PersonName personName) {
        return personGroup.stream()
                .map(Person::getPersonName)
                .anyMatch(name -> name.equals(personName));
    }

    public List<String> getNames() {
        return personGroup.stream()
                .map(Person::getPersonName)
                .map(PersonName::name)
                .toList();
    }

    public List<PersonName> getPersonNames() {
        return personGroup.stream()
                .map(Person::getPersonName)
                .toList();
    }

    public int getPersonCount() {
        return personGroup.size();
    }

    public List<Person> getPersonGroup() {
        return personGroup;
    }
}
