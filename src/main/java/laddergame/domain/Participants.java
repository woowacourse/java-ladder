package laddergame.domain;

import java.util.List;

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
}
