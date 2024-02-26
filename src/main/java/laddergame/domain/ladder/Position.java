package laddergame.domain.ladder;

import java.util.Objects;
import laddergame.exception.LadderGameException;

public class Position {

    private final int position;

    public Position(final int position) {
        validateRange(position);
        this.position = position;
    }

    private void validateRange(final int position) {
        if (position < 0) {
            throw new LadderGameException("[ERROR] 음수를 포지션으로 가질 수 없습니다.");
        }
    }

    public Position increase() {
        return new Position(position + 1);
    }

    public Position decrease() {
        return new Position(position - 1);
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final Position position1)) {
            return false;
        }
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

}
