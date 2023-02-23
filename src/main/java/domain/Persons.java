package domain;

import exception.ErrorCode;
import java.util.List;
import java.util.stream.Collectors;

public class Persons {
    private final List<Person> persons;

    private Persons(List<Person> persons) {
        this.persons = persons;
    }

    public static Persons from(List<String> names) {
        validate(names);
        return initializePerson(names);
    }

    private static void validate(List<String> names) {
        if (isNameDuplicate(names)) {
            throw new IllegalArgumentException(ErrorCode.NAME_DUPLICATE.getMessage());
        }
    }

    private static boolean isNameDuplicate(List<String> names) {
        return names.size() != names.stream()
                .distinct()
                .count();
    }

    private static Persons initializePerson(List<String> names) {
        List<Person> persons = names.stream()
                .map((name) -> new Person(name, names.indexOf(name)))
                .collect(Collectors.toList());
        return new Persons(persons);
    }

    public int getTotalPersonCount() {
        return persons.size();
    }

    public List<String> getAllPersonName() {
        return persons.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
    }

    public List<Integer> getAllPersonPosition() {
        return persons.stream()
                .map(Person::getPosition)
                .collect(Collectors.toList());
    }

    public String findPersonNameInPosition(int position) {
        for (Person person : persons) {
            if (position == person.getPosition()) {
                return person.getName();
            }
        }
        return null;
    }
}
