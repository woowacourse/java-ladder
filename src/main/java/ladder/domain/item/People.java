package ladder.domain.item;

import java.util.ArrayList;
import java.util.List;

public class People {
    private static final int MIN_SIZE = 2;

    private final List<Person> people;

    public People(List<String> peopleNames) {
        List<String> copy = new ArrayList<>(peopleNames);
        validate(copy);

        people = copy.stream()
                .map(Person::new)
                .toList();
    }

    private static void validateDuplication(List<String> peopleNames) {
        long distinctSize = peopleNames.stream()
                .distinct()
                .count();

        if (distinctSize != peopleNames.size()) {
            throw new IllegalArgumentException("사람의 이름은 중복될 수 없습니다.");
        }
    }

    private void validate(List<String> peopleNames) {
        validateSize(peopleNames);
        validateDuplication(peopleNames);
    }

    private void validateSize(List<String> peopleNames) {
        if (peopleNames.size() < MIN_SIZE) {
            throw new IllegalArgumentException("사다리 게임에 참여하는 사람들의 수는 2명 이상이어야 합니다.");
        }
    }

    public String getNameByIndex(int index) {
        return people.get(index).getName();
    }

    public int count() {
        return people.size();
    }

    public List<String> getPeopleNames() {
        return people.stream()
                .map(Person::getName)
                .toList();
    }
}
