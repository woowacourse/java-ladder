package domain.participants;

import exception.participants.EmptyNameException;
import exception.participants.InvalidPersonNameException;

public class Participant {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private final String name;

    public Participant(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (isBlank(name)) {
            throw new EmptyNameException();
        }
        if (isInvalidLength(name)) {
            throw new InvalidPersonNameException();
        }
    }

    private boolean isBlank(String name) {
        return name == null || name.isBlank();
    }

    private boolean isInvalidLength(String name) {
        return name.length() < MIN_LENGTH || name.length() > MAX_LENGTH;
    }

    public String getName() {
        return name;
    }
}
