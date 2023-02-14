package domain;

import exception.InvalidPersonNameException;
import exception.NameContainsIdentifierException;

public class Person {

    private final String name;
    private final int identifier;

    public Person(String name, int identifier) {
        validateName(name);
        this.name = name;
        this.identifier = identifier;
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
