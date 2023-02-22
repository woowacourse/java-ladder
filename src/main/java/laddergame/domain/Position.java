package laddergame.domain;

import java.util.Objects;

public class Position {

    private static final int START_INDEX = 0;

    private int order;
    private final int playerCount;

    public Position(final int order, final int playerCount) {
        this.playerCount = playerCount;
        validateRange(order);
        this.order = order;
    }

    private void validateRange(final int order) {
        if (order < START_INDEX || order >= playerCount) {
            throw new IllegalStateException(String.format("%d이상 %d미만의 값만 입력해주세요.", START_INDEX, playerCount));
        }
    }

    public void moveForward() {
        if (order - 1 < START_INDEX) {
            throw new IllegalStateException("제일 앞에선 더 앞으로 갈 수 없습니다.");
        }

        order--;
    }

    public void goBack() {
        if (order + 1 >= playerCount) {
            throw new IllegalStateException("제일 뒤에선 더 뒤로 갈 수 없습니다.");
        }
        order++;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position = (Position) o;
        return order == position.order && playerCount == position.playerCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, playerCount);
    }

    public int getOrder() {
        return order;
    }
}
