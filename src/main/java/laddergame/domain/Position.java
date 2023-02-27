package laddergame.domain;

import java.util.Objects;

public class Position {

    private static final int START_INDEX = 0;

    private final int order;


    private Position(final int order) {
        this.order = order;
    }

    public static Position of(final int order, final int playerCount) {
        validateRange(order, playerCount);
        return new Position(order);
    }

    private static void validateRange(final int order, final int playerCount) {
        if (order < START_INDEX || order >= playerCount) {
            throw new IllegalStateException(String.format("%d이상 %d미만의 값만 입력해주세요.", START_INDEX, playerCount));
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position = (Position) o;
        return order == position.order;
    }

    @Override
    public int hashCode() {
        return Objects.hash(order);
    }

    public int getOrder() {
        return order;
    }
}
