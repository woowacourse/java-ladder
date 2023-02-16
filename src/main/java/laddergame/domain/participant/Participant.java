package laddergame.domain.participant;

public class Participant {

    private final ParticipantName participantName;

    private Participant(final String name) {
        this.participantName = ParticipantName.create(name);
    }

    public static Participant create(final String name) {
        return new Participant(name);
    }

    public String getName() {
        return participantName.getName();
    }
}
