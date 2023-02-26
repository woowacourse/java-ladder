package domain;

import static utils.ErrorMessage.*;

public class Name {

    public static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;

    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name from(String name) {
        name = name.strip();
        validateNameLength(name);
        return new Name(name);
    }

    private static void validateNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                String.format(INVALID_USERNAME_LENGTH.getMessage(),
                    MIN_NAME_LENGTH, MAX_NAME_LENGTH));
        }
    }

    public String getName() {
        return name;
    }
}
