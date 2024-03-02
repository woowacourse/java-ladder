package model.people;

import java.util.List;

public class People {
    private final List<Person> personGroup;
    private final PersonCount personCount;

    private People(final List<Person> personGroup, final PersonCount personCount) {
        validateDuplicatePerson(personGroup);
        this.personGroup = personGroup;
        this.personCount = personCount;
    }

    public static People from(final List<String> names) {
        final List<Person> personGroup = names.stream()
                .map(Person::new)
                .toList();
        final PersonCount personCount = new PersonCount(names.size());
        return new People(personGroup, personCount);
    }

    private void validateDuplicatePerson(final List<Person> personGroup) {
        int uniquePersonCount = (int) personGroup.stream()
                .distinct()
                .count();
        if (personGroup.size() != uniquePersonCount) {
            throw new IllegalArgumentException("여자들의 이름 중 중복되는 이름은 존재할 수 없습니다.");
        }
    }

    public Person findBy(int index) {
        return personGroup.get(index);
    }

    public List<String> getNames() {
        return personGroup.stream()
                .map(Person::getName)
                .toList();
    }

    public PersonCount getPersonCount() {
        return personCount;
    }
}
