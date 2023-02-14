package laddergame.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Persons {
    private final static int MIN_PERSON_LENGTH = 2;
    private final static String ERROR_PERSON_LENGTH = "최소 참여자의 수는 " + MIN_PERSON_LENGTH + "명 이상이어야 합니다.";
    private final static String ERROR_DUPLICATION = "참여자들 이름에 중복이 있어서는 안됩니다.";

    private final List<Person> persons;

    public Persons(List<String> names) {
        validatePersonLength(names);
        validateDuplication(names);
        this.persons = new ArrayList<>();
        addPerson(names);
    }

    private void addPerson(List<String> names) {
        for (String name : names) {
            persons.add(new Person(name));
        }
    }

    private static void validatePersonLength(List<String> names) {
        if (names.size() < MIN_PERSON_LENGTH) {
            throw new IllegalArgumentException(ERROR_PERSON_LENGTH);
        }
    }

    private static void validateDuplication(List<String> names) {
        Set<String> removeDuplicateNames = new HashSet<>(names);
        if (removeDuplicateNames.size() != names.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATION);
        }
    }
}
