package laddergame.domain.participant;

public class ParticipantPosition {

    private final int position;

    public ParticipantPosition(final int position) {
        this.position = position;
    }

    public ParticipantPosition increase() {
        return new ParticipantPosition(position + 1);
    }

    public ParticipantPosition decrease() {
        return new ParticipantPosition(position - 1);
    }

    public int getPosition() {
        return position;
    }
}
