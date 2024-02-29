package domain.result;

import java.util.Objects;

public class Position {

    private Integer position;

    public Position(int position) {
        validate(position);
        this.position = position;
    }

    public void movePositionLeft() {
        position -= 1;
    }

    public void movePositionRight() {
        position += 1;
    }

    public int getPosition() {
        return this.position;
    }

    private void validate(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("[ERROR] 위치는 음수일 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Position other = (Position) obj;
        return Objects.equals(position, other.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return Integer.toString(position);
    }
}
