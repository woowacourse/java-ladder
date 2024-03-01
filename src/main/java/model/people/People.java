package model.people;

import java.util.List;

public class People {
    private final List<Person> personGroup;
    private final PersonCount personCount;

    private People(final List<Person> personGroup, final PersonCount personCount) {
        this.personCount = personCount;
        this.personGroup = personGroup;
    }

    public static People from(final List<String> names) {
        final List<Person> personGroup = names.stream()
                .map(Person::new)
                .toList();
        final PersonCount personCount = new PersonCount(names.size());
        return new People(personGroup, personCount);
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
