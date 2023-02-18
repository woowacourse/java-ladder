package domain;

import static utils.ErrorMessage.INVALID_USER_NAME_LENGTH;

public class Name {

    public final static int MAX_NAME_LENGTH = 5;

    private final int MIN_NAME_LENGTH = 1;
    private final String name;

    public Name(String name) {
        name = name.trim();
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(
                String.format(INVALID_USER_NAME_LENGTH.getMessage(),
                    MIN_NAME_LENGTH, MAX_NAME_LENGTH));
        }
    }

    public String getName() {
        return name;
    }
}
