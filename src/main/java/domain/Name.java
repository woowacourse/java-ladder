package domain;

import static utils.ErrorMessage.INVALID_USER_NAME_FORMAT;
import static utils.ErrorMessage.INVALID_USER_NAME_LENGTH;

public class Name {
    public final static int MIN_NAME_LENGTH = 1;
    public final static int MAX_NAME_LENGTH = 5;
    public final static String BLANK = " ";

    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        validateNameLength(name);
        validateNameFormat(name);
    }

    private void validateNameLength(String name) {
        if (isLongerThanMaxLength(name) || isShorterThanMinLength(name)) {
            throw new IllegalArgumentException(INVALID_USER_NAME_LENGTH.getMessage());
        }
    }

    private boolean isShorterThanMinLength(String name) {
        return name.length() < MIN_NAME_LENGTH;
    }

    private boolean isLongerThanMaxLength(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

    private void validateNameFormat(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException(INVALID_USER_NAME_FORMAT.getMessage());
        }
    }

    public String getName() {
        return name;
    }
}
