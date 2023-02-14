package domain;

import exception.InvalidPersonNameException;
import exception.NameContainsIdentifierException;

public class Person {

    private final String name;

    public Person(String name) {
        final int maxLength = 5;
        final String identifier = "-";
        if (name == null || name.isBlank() || name.length() > maxLength) {
            throw new InvalidPersonNameException();
        }
        if (name.contains(identifier)) {
            throw new NameContainsIdentifierException();
        }
        this.name = name;
    }
}
