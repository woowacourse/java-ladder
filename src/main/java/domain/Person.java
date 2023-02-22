package domain;

import exception.ErrorCode;
import type.LadderElementInformation;

public class Person {
    private final String name;

    public Person(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() < LadderElementInformation.MIN_LENGTH.getLength()
                || name.length() > LadderElementInformation.MAX_LENGTH.getLength()) {
            throw new IllegalArgumentException(String.format(ErrorCode.LENGTH_OUT_OF_RANGE.getMessage(),
                    LadderElementInformation.MIN_LENGTH.getLength(),
                    LadderElementInformation.MAX_LENGTH.getLength()));
        }
    }

    public String getName() {
        return name;
    }
}
