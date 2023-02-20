package laddergame.domain.participant;

public class ParticipantOrder {

    private final int order;

    private ParticipantOrder(final int order) {
        this.order = order;
    }

    public static ParticipantOrder create(final int order) {
        return new ParticipantOrder(order);
    }
}
