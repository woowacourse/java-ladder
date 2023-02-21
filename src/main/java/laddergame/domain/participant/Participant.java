package laddergame.domain.participant;

import java.util.Objects;

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

    public boolean isSameName(final String targetName) {
        return getName().equals(targetName);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(participantName, that.participantName) && Objects.equals(participantOrder, that.participantOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participantName, participantOrder);
    }

    public String getName() {
        return participantName.getName();
    }

    public int getOrder() {
        return participantOrder.getOrder();
    }
}
