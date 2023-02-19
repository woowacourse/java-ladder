package laddergame.domain.participant;

import laddergame.domain.exception.BlankException;

public class ParticipantName {

    private static final char INVALID_INCLUSION = ' ';
    private static final int MAX_LENGTH = 5;
    private static final String PARTICIPANT_NAME = "참가자 이름은";
    private static final String INVALID_NANE_LENGTH = "[ERROR] %s %d글자를 초과할 수 없습니다.";

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
        if (name.isBlank() || name.indexOf(INVALID_INCLUSION) != -1) {
            throw new BlankException(PARTICIPANT_NAME);
        }
    }

    private void validateNameLength(final String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format(INVALID_NANE_LENGTH, PARTICIPANT_NAME, MAX_LENGTH));
        }
    }

    public String getName() {
        return name;
    }
}
