package ladder.domain.participant;

import ladder.exception.InvalidNameLengthException;
import ladder.exception.NonAlphabeticNameException;

public class Participant {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_REGEX = "^[a-zA-Z]*$";

    private final String name;

    public Participant(String name) {
        name = name.trim();
        validateNameLength(name);
        validateIsAlphabetic(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new InvalidNameLengthException();
        }
    }

    private static void validateIsAlphabetic(String name) {
        if (!name.matches(NAME_REGEX)) {
            throw new NonAlphabeticNameException();
        }
    }

    public String getName() {
        return name;
    }
}
