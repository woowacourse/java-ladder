package laddergame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private final List<Person> people;

    public Participants(List<Person> people) {
        if (people == null) {
            throw new IllegalArgumentException();
        }
        if (people.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.people = people;
    }

    public int getSize() {
        return people.size();
    }

    public List<String> getNames() {
        return people.stream()
                .map(Person::getName)
                .collect(Collectors.toUnmodifiableList());
    }
}
