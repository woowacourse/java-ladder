package model.people;

import model.Name;

public class Person {
    private final Name name;

    public Person(final String rawName) {
        this.name = new PersonName(rawName);
    }

    public String getName() {
        return name.getName();
    }
}
