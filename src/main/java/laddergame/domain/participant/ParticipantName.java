package laddergame.domain.participant;

import static laddergame.domain.message.ErrorMessage.INVALID_NAME_BLANK;
import static laddergame.domain.message.ErrorMessage.INVALID_NANE_LENGTH;

public class ParticipantName {

    private static final char INVALID_INCLUSION = ' ';
    private static final int MAX_LENGTH = 5;

    private final String name;

    private ParticipantName(final String name) {
        validateNameBlank(name);
        validateNameLength(name);
        this.name = name;
    }

    public static ParticipantName create(final String name) {
        return new ParticipantName(name);
    }

    private void validateNameBlank(final String name) {
        if (name.indexOf(INVALID_INCLUSION) != -1) {
            throw new IllegalArgumentException(INVALID_NAME_BLANK.getMessage());
        }
    }

    private void validateNameLength(final String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_NANE_LENGTH.getMessage());
        }
    }

    public String getName() {
        return name;
    }
}
