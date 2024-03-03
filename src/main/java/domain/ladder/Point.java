package domain.ladder;

import java.util.Objects;
import java.util.function.BooleanSupplier;

public class Point {
    private final boolean left;
    private final boolean right;

    private Point(final boolean left, final boolean right) {
        validate(left, right);
        this.left = left;
        this.right = right;
    }

    public static Point of(final boolean left, final boolean right) {
        return new Point(left, right);
    }

    public static Point leftEmpty(final BooleanSupplier booleanSupplier) {
        return new Point(false, booleanSupplier.getAsBoolean());
    }

    public static Point rigthEmpty(final BooleanSupplier booleanSupplier) {
        return new Point(booleanSupplier.getAsBoolean(), false);
    }

    public static Point leftConncect() {
        return new Point(true, false);
    }

    public static Point random(final BooleanSupplier booleanSupplier) {
        boolean left = booleanSupplier.getAsBoolean();
        boolean right = booleanSupplier.getAsBoolean();

        if (left) {
            right = false;
        }
        return new Point(left, right);
    }

    private void validate(final boolean left, final boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("양쪽에 모두 다리가 있을 수 없습니다.");
        }
    }

    public int applyMove(final int index) {
        if (right) {
            return index + 1;
        }
        if (left) {
            return index - 1;
        }
        return index;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isLeft() {
        return left;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Point point = (Point) o;
        return left == point.left && right == point.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
