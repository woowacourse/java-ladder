package model;

import exception.BlankNameException;
import exception.WrongNameLengthException;

public class Name {

    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validateBlank(name);
        validateLength(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new WrongNameLengthException();
        }
    }

    private void validateBlank(String name) {
        if (name.isBlank()) {
            throw new BlankNameException();
        }
    }

    public String getName() {
        return name;
    }
}
