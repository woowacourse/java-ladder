package laddergame.domain.participant;

import java.util.Objects;

public class ParticipantOrder {

    private final int order;

    private ParticipantOrder(final int order) {
        this.order = order;
    }

    public static ParticipantOrder create(final int order) {
        return new ParticipantOrder(order);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipantOrder that = (ParticipantOrder) o;
        return order == that.order;
    }

    @Override
    public int hashCode() {
        return Objects.hash(order);
    }

    public int getOrder() {
        return order;
    }
}
