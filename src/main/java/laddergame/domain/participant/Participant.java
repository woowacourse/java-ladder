package laddergame.domain.participant;

import java.util.Objects;

public class Participant {

    private final ParticipantName name;
    private final ParticipantOrder order;

    private Participant(final String name, final int order) {
        this.name = ParticipantName.create(name);
        this.order = ParticipantOrder.create(order);
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
        return Objects.equals(name, that.name) && Objects.equals(order, that.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, order);
    }

    public String getName() {
        return name.getName();
    }

    public int getOrder() {
        return order.getOrder();
    }
}
