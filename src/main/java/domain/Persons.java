package domain;

import exception.ErrorCode;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Persons {
    private static final int MIN_PLAYER = 2;
    private final List<Person> persons;

    public Persons(List<Person> persons) {
        validate(persons);
        this.persons = persons;
    }

    private void validate(List<Person> persons) {
        if (isNameDuplicate(persons)) {
            throw new IllegalArgumentException(ErrorCode.NAME_DUPLICATE.getMessage());
        }
        if (persons.size() < MIN_PLAYER) {
            throw new IllegalArgumentException(ErrorCode.NOT_ENOUGH_PLAYER.getMessage());
        }
    }

    private boolean isNameDuplicate(List<Person> names) {
        return names.size() != names.stream()
                .map(Person::getName)
                .distinct()
                .count();
    }

    public int getLongestPersonNameLength() {
        List<Integer> namesLength = persons.stream()
                .map(person -> person.getName().length())
                .collect(Collectors.toList());
        return Collections.max(namesLength);
    }

    public int getTotalPersonCount() {
        return persons.size();
    }

    public List<Person> getPersons() {
        return persons;
    }

    public String findNameByPosition(int position) {
        return persons.get(position)
                .getName();
    }
}
