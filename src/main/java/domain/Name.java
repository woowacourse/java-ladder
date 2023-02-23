package domain;

import static utils.ErrorMessage.*;

public class Name {

    public static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;

    private final String name;

    public Name(String name) {
        name = name.strip();

        validateNameLengthByMinimumLimit(name);
        validateNameLengthByMaximumLimit(name);

        this.name = name;
    }

    private void validateNameLengthByMinimumLimit(String name) {
        if (name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(
                String.format(INVALID_USERNAME_LENGTH_BY_MINIMUM_LIMIT.getMessage(),
                    MIN_NAME_LENGTH));
        }
    }

    private void validateNameLengthByMaximumLimit(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                String.format(INVALID_USERNAME_LENGTH_BY_MAXIMUM_LIMIT.getMessage(),
                    MAX_NAME_LENGTH));
        }
    }

    public String getName() {
        return name;
    }
}
