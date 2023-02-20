package domain;

import java.util.Collections;
import java.util.List;

public class People {

    private final List<Person> people;

    public People(List<Person> people) {
        this.people = people;
    }

    public int getSize() {
        return people.size();
    }

    public List<Person> getAllPerson() {
        return Collections.unmodifiableList(people);
    }
}
