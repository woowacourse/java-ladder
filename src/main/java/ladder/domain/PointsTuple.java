package ladder.domain;

import java.util.List;
import java.util.Objects;

public class PointsTuple {
    private final Boolean left;
    private final Boolean right;

    public PointsTuple(final List<Boolean> points) {
        if (points.size() != 2)
            throw new IllegalArgumentException();
        left = points.get(0);
        right = points.get(1);
    }

    boolean canMoveRight() {
        return right;
    }

    boolean canMoveLeft() {
        return left;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointsTuple tuple = (PointsTuple) o;
        return Objects.equals(left, tuple.left) &&
                Objects.equals(right, tuple.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}