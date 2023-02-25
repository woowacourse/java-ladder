package laddergame.domain.participant;

public class ParticipantPosition {

    private static final int POSITION_UNIT = 1;

    private final int position;

    public ParticipantPosition(final int position) {
        this.position = position;
    }

    public ParticipantPosition increase() {
        return new ParticipantPosition(position + POSITION_UNIT);
    }

    public ParticipantPosition decrease() {
        return new ParticipantPosition(position - POSITION_UNIT);
    }

    public int getPosition() {
        return position;
    }
}
