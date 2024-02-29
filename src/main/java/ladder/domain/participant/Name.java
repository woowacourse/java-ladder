package ladder.domain.participant;

import ladder.exception.participant.InvalidNameLengthException;
import ladder.exception.participant.NonAlphabeticNameException;
import ladder.exception.participant.ProhibitedNameException;

public record Name(String value) {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String PROHIBITED_NAME = "all";
    private static final String NAME_REGEX = "^[a-zA-Z]*$";

    public Name {
        value = value.trim();
        validateNameLength(value);
        validateIsAlphabetic(value);
        validateIsNotProhibited(value);
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

    private static void validateIsNotProhibited(final String name) {
        if (PROHIBITED_NAME.equals(name)) {
            throw new ProhibitedNameException();
        }
    }
}
