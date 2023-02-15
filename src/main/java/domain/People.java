package domain;

import java.util.List;
import java.util.stream.Collectors;

public class People {

    private final List<Person> people;

    public People(List<Person> people) {
        this.people = people;
    }

    public List<String> getNames() {
        return people.stream()
            .map(Person::getName)
            .collect(Collectors.toList());
    }
}
