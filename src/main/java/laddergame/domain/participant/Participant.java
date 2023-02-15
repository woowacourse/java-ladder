package laddergame.domain.participant;

public class Participant {

    private final ParticipantName participantName;

    public Participant(final String name) {
        this.participantName = new ParticipantName(name);
    }

    public String getName() {
        return participantName.getName();
    }
}
