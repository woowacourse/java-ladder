package laddergame.domain.participant;

import laddergame.domain.exception.participant.ParticipantNameBlankException;
import laddergame.domain.exception.participant.ParticipantNameLengthException;

import java.util.Objects;

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
        if (name.isBlank() || name.indexOf(INVALID_INCLUSION) != -1) {
            throw new ParticipantNameBlankException();
        }
    }

    private void validateNameLength(final String name) {
        if (name.length() > MAX_LENGTH) {
            throw new ParticipantNameLengthException(MAX_LENGTH);
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipantName that = (ParticipantName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }
}
