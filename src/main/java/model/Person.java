package model;

public class Person {
    private final PersonName personName;

    private Person(final PersonName personName) {
        this.personName = personName;
    }

    public static Person from(final String name) {
        return new Person(new PersonName(name));
    }

    public String getName() {
        return personName.name();
    }
}
