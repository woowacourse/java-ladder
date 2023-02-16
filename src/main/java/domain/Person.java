package domain;

import exception.InvalidPersonNameException;

public class Person {

    private final String name;

    public Person(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (!isValidLength(name)) {
            throw new InvalidPersonNameException();
        }
    }

    private boolean isValidLength(String name) {
        final int maxLength = 5;
        return name != null && !name.isBlank() && name.length() <= maxLength;
    }

    public String getName() {
        return name;
    }
}
