package domain;

import constant.Exception;
import exception.domain.NameExceptionMessage;

public class Name {

    public static final int MAX_OF_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validateNoName(name);
        validateNameLength(name);
        this.name = name;
    }

    private void validateNoName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(NameExceptionMessage.NO_NAME.getExceptionMessage());
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_OF_NAME_LENGTH) {
            throw new IllegalArgumentException(NameExceptionMessage.OUT_OF_RANGE_NAME_LENGTH.getExceptionMessage());
        }
    }

    public String getName() {
        return name;
    }
}
