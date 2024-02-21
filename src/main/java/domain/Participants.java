package domain;

import java.util.Arrays;
import java.util.List;

public class Participants {

    private final List<Person> people;

    public Participants(String[] names) {
        if (names.length < 2) {
            throw new IllegalArgumentException("[ERROR] 참가자는 2명 이상이어야 합니다.");
        }
        if (names.length > 50) {
            throw new IllegalArgumentException("[ERROR] 참가자는 50명 이하여야 합니다.");
        }
        if (Arrays.stream(names).distinct().count() != names.length) {
            throw new IllegalArgumentException("[ERROR] 참가자 이름은 중복될 수 없습니다.");
        }

        this.people = Arrays.stream(names)
                .map(Person::new)
                .toList();
    }

    public List<String> getPeopleName() {
        return people.stream()
                .map(Person::getName)
                .toList();
    }

    public int getPeopleCount() {
        return people.size();
    }
}
