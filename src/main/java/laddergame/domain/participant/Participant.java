package laddergame.domain.participant;

import java.util.Objects;

public class Participant {

    private final ParticipantName participantName;

    private Participant(final String name) {
        this.participantName = ParticipantName.create(name);
    }

    public static Participant create(final String name) {
        return new Participant(name);
    }

    public boolean isSameName(final String name) {
        return participantName.isSameName(name);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return participantName.equals(that.participantName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participantName);
    }

    @Override
    public String toString() {
        return "Participant{" +
                "participantName=" + participantName +
                '}';
    }

    public String getName() {
        return participantName.getName();
    }
}
