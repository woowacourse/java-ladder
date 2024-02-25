package ladder.domain.participant;

import ladder.exception.participant.InvalidNameLengthException;
import ladder.exception.participant.NonAlphabeticNameException;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_REGEX = "^[a-zA-Z]*$";

    private final String value;

    public Name(String value) {
        value = value.trim();
        validateNameLength(value);
        validateIsAlphabetic(value);
        this.value = value;
    }

    private void validateNameLength(final String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new InvalidNameLengthException();
        }
    }

    private static void validateIsAlphabetic(final String name) {
        if (!name.matches(NAME_REGEX)) {
            throw new NonAlphabeticNameException();
        }
    }

    public String getValue() {
        return value;
    }
}
