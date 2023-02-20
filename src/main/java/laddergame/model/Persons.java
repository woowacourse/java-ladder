package laddergame.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Persons {
    private static final int MIN_PERSON_LENGTH = 2;
    private static final String ERROR_PERSON_LENGTH = "최소 참여자의 수는 " + MIN_PERSON_LENGTH + "명 이상이어야 합니다.";
    private static final String ERROR_DUPLICATION = "참여자들 이름에 중복이 있어서는 안됩니다.";

    private final List<Person> persons;

    public Persons(List<String> names) {
        validatePersonLength(names);
        validateDuplication(names);
        this.persons = convertToPeople(names);
    }

    private static List<Person> convertToPeople(List<String> names) {
        return names.stream()
                .map(Person::new)
                .collect(Collectors.toList());
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

    public int getNumberOfPersons() {
        return persons.size();
    }

    public List<Person> getPersons() {
        return persons;
    }
}
