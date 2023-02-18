package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class People {

    private static final int MIN_PARTICIPANTS = 2;

    private final List<Person> people;

    public People(List<Person> people) {
        validatePeopleSize(people);
        validateNoDuplicated(people);
        this.people = List.copyOf(people);
    }

    private void validatePeopleSize(List<Person> people) {
        if (people.size() < MIN_PARTICIPANTS) {
            throw new IllegalArgumentException("참가자는 2명 이상이어야 합니다");
        }
    }

    private void validateNoDuplicated(List<Person> people) {
        if (hasDuplicated(people)) {
            throw new IllegalArgumentException("이름은 중복될 수 없습니다.");
        }
    }

    private boolean hasDuplicated(List<Person> people) {
        Set<Person> duplicateRemoval = new HashSet<>(people);
        return duplicateRemoval.size() != people.size();
    }

    public List<Person> getParticipants() {
        return people;
    }
}
