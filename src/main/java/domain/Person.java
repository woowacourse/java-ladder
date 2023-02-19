package domain;

import exception.EmpytInputException;
import exception.InvalidPersonNameException;

public class Person {

    private final String name;

    public Person(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (isBlank(name)) {
            throw new EmpytInputException();
        }
        if (isInvalidLength(name)) {
            throw new InvalidPersonNameException();
        }
    }

    private boolean isBlank(String name) {
        return name == null || name.isBlank();
    }

    private boolean isInvalidLength(String name) {
        final int minLength = 1;
        final int maxLength = 5;
        return name.length() < minLength || name.length() > maxLength;
    }

    public String getName() {
        return name;
    }
}
