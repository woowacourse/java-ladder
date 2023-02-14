package domain;

import exception.ErrorCode;

public class Person {
    private static final int MAX_NAME = 5;
    private static final int MIN_NAME = 1;
    private final String name;

    Person(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() < MIN_NAME || name.length() > MAX_NAME) {
            throw new IllegalArgumentException(
                    String.format(ErrorCode.NAME_OUT_OF_RANGE.getMessage(), MIN_NAME, MAX_NAME));
        }
    }

    public String getName() {
        return name;
    }
}
