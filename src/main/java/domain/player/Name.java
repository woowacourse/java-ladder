package domain.player;

import utils.ErrorMessage;

public class Name {

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
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH_ERROR.getMessage());
        }
    }

    private void validateSpace(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.NAME_FORMAT_ERROR.getMessage());
        }
    }

    public String getName() {
        return name;
    }
}
