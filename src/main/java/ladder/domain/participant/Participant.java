package ladder.domain.participant;

public class Participant {
    private final ParticipantName name;

    public Participant(final String name) {
        this.name = new ParticipantName(name);
    }

    public ParticipantName getName() {
        return name;
    }
}
