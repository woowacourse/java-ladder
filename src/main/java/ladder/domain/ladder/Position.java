package ladder.domain.ladder;

import java.util.Objects;

public class Position {
    private int value;

    public Position(int value) {
        if(value < 0) {
            throw new IllegalArgumentException("0보다 작은 숫자로 내려갈 수 없습니다");
        }

        this.value = value;
    }

    public Position increase() {
        return new Position(value +1);
    }

    public Position decrease() {
        return new Position(value -1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
