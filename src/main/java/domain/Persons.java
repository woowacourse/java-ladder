package domain;

import java.util.ArrayList;
import java.util.List;

public class Persons {
    private final List<Person> persons;

    public Persons(List<Person> persons) {
        validate(persons);
        this.persons = persons;
    }

    private void validate(List<Person> persons) {
        List<String> validatedNames = new ArrayList<>();
        for (Person person : persons) {
            String name = person.getName();
            if (validatedNames.contains(name)) {
                throw new IllegalArgumentException();
            }
            validatedNames.add(name);
        }
    }
}
