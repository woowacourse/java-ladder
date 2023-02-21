package domain;

import exception.EmpytInputException;
import exception.InvalidPersonNameException;

public class Person {

    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 5;
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
        return name.length() < MIN_LENGTH || name.length() > MAX_LENGTH;
    }

    public String getName() {
        return name;
    }
}
