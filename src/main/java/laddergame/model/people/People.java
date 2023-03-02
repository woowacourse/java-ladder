package laddergame.model.people;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class People {
    private static final int MIN_PEOPLE_COUNT = 2;

    private final List<Person> people;

    public People(List<String> names) {
        validatePeopleSize(names);
        validateDuplication(names);
        this.people = makePeople(names);
    }

    private static void validatePeopleSize(List<String> names) {
        if (names.size() < MIN_PEOPLE_COUNT) {
            throw new IllegalArgumentException("최소 참여자의 수는 " + MIN_PEOPLE_COUNT + "명 이상이어야 합니다.");
        }
    }

    private static void validateDuplication(List<String> names) {
        Set<String> removeDuplicateNames = new HashSet<>(names);
        if (removeDuplicateNames.size() != names.size()) {
            throw new IllegalArgumentException("참여자들 이름에 중복이 있어서는 안됩니다.");
        }
    }

    private static List<Person> makePeople(List<String> names) {
        return names.stream()
                .map(Person::new)
                .collect(Collectors.toList());
    }

    public int size() {
        return people.size();
    }

    public List<Person> getPeople() {
        return people;
    }
}
