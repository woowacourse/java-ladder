package laddergame.domain.participant;

import laddergame.domain.exception.BlankException;

public class ParticipantName {

    private static final char INVALID_INCLUSION = ' ';
    private static final int MAX_LENGTH = 5;
    public static final String INVALID_NANE_LENGTH = "[ERROR] 이름은 다섯 글자를 초과할 수 없습니다.";

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
            throw new BlankException();
        }
    }

    private void validateNameLength(final String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_NANE_LENGTH);
        }
    }

    public String getName() {
        return name;
    }
}
