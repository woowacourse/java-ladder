package domain;

import exception.InvalidPersonNameException;
import exception.NameContainsIdentifierException;

public class Person {

    private final String name;

    public Person(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        final String identifier = "-";
        if (!isValidLength(name)) {
            throw new InvalidPersonNameException();
        }
        if (name.contains(identifier)) {
            throw new NameContainsIdentifierException();
        }
    }

    private boolean isValidLength(String name) {
        final int maxLength = 5;
        return name != null && !name.isBlank() && name.length() <= maxLength;
    }
}
