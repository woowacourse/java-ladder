package domain.player;

import java.util.Objects;

public class Position { //TODO 자주 사용할 값은 캐싱해 둘 수 있다.

    private final int positionValue;
    public Position(int positionValue) {
        validate(positionValue);
        this.positionValue = positionValue;
    }

    private void validate(int positionValue) {
        if (positionValue < 0) {
            throw new IllegalArgumentException("음의 위치를 가질 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return positionValue == position.positionValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionValue);
    }
}
