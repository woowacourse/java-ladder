package domain.player;

import utils.ErrorMessage;

public class Name {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String SPACE = " ";

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateLength(name);
        validateSpace(name);
    }

    private void validateLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH_ERROR.getMessage());
        }
    }

    private void validateSpace(String name) {
        if (name.contains(SPACE)) {
            throw new IllegalArgumentException(ErrorMessage.NAME_FORMAT_ERROR.getMessage());
        }
    }

    public String getName() {
        return name;
    }
}
