package ladder.domain;

import java.util.Objects;

public class PlayerPosition implements Comparable<PlayerPosition> {
    private final int position;

    public PlayerPosition(int position) {
        validateIsPositive(position);
        this.position = position;
    }

    private void validateIsPositive(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("위치는 0 이상입니다");
        }
    }

    public PlayerPosition increase() {
        return new PlayerPosition(position + 1);
    }

    public PlayerPosition decrease() {
        return new PlayerPosition(position - 1);
    }

    @Override
    public int compareTo(PlayerPosition p) {
        return position - p.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayerPosition p = (PlayerPosition) o;
        return position == p.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public int getValue() {
        return position;
    }
}
