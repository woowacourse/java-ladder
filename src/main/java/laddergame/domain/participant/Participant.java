package laddergame.domain.participant;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.Line;

import java.util.List;
import java.util.Objects;

public class Participant {

    private final ParticipantName participantName;
    private ParticipantPosition participantPosition;

    private Participant(final String name, final int position) {
        this.participantName = ParticipantName.create(name);
        this.participantPosition = new ParticipantPosition(position);
    }

    public static Participant create(final String name, final int position) {
        return new Participant(name, position);
    }

    public boolean isSameName(final String name) {
        return participantName.isSameName(name);
    }

    public void moveToDestination(final Ladder ladder) {
        final List<Line> lines = ladder.getLines();
        lines.forEach(this::moveAlongLine);
    }

    private void moveAlongLine(final Line line) {
        if (line.hasRung(participantPosition.getPosition())) {
            participantPosition = participantPosition.increase();
            return;
        }
        if (line.hasRung(participantPosition.getPosition() - 1)) {
            participantPosition = participantPosition.decrease();
        }
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

    public int getParticipantPosition() {
        return participantPosition.getPosition();
    }
}
