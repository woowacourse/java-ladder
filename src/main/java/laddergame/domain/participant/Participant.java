package laddergame.domain.participant;

public class Participant {

    private final ParticipantName participantName;
    private final ParticipantOrder participantOrder;

    private Participant(final String name, final int order) {
        this.participantName = ParticipantName.create(name);
        this.participantOrder = ParticipantOrder.create(order);
    }

    public static Participant create(final String name, final int order) {
        return new Participant(name, order);
    }

    public String getName() {
        return participantName.getName();
    }
}
