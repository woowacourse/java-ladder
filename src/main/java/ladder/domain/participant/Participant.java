package ladder.domain.participant;

public class Participant {
    private final ParticipantName name;
    private final ParticipantPosition position;

    public Participant(final String name, final int position) {
        this.name = new ParticipantName(name);
        this.position = new ParticipantPosition(position);
    }

    public ParticipantName getName() {
        return name;
    }

    public ParticipantPosition getPosition() {
        return position;
    }
}
