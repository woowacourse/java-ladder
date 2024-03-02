package domain.ladder;

import domain.player.PlayerCount;
import java.util.List;
import java.util.Objects;
import java.util.function.BooleanSupplier;

public class Point {
    private final boolean left;
    private final boolean right;

    public Point(final boolean left, final boolean right) {
        validate(left, right);
        this.left = left;
        this.right = right;
    }

    public static Point create(final BooleanSupplier booleanSupplier, final PlayerCount playerCount,
                               final List<Point> points) {
        if (isFirstPoint(points) || isPreviousConnected(points)) {
            return new Point(false, booleanSupplier.getAsBoolean());
        }
        if (isConnected(points)) {
            return new Point(true, false);
        }
        if (isLastPoint(points, playerCount)) {
            return new Point(booleanSupplier.getAsBoolean(), false);
        }
        boolean left = booleanSupplier.getAsBoolean();
        boolean right = booleanSupplier.getAsBoolean();

        if (left) {
            right = false;
        }
        return new Point(left, right);
    }

    private static boolean isPreviousConnected(final List<Point> points) {
        return points.get(points.size() - 1).isLeft();
    }

    private static boolean isFirstPoint(final List<Point> points) {
        return points.isEmpty();
    }

    private static boolean isConnected(final List<Point> points) {
        final int index = points.size();
        if (index == 0) {
            return false;
        }
        return points.get(index - 1).isRight();
    }

    private static boolean isLastPoint(final List<Point> points, final PlayerCount playerCount) {
        return playerCount.isSameWith(points.size() + 1);
    }

    private void validate(final boolean left, final boolean right) {
        if (left && right) {
            throw new IllegalArgumentException("양쪽에 모두 다리가 있을 수 없습니다.");
        }
    }

    public static Point of(final boolean left, final boolean right) {
        return new Point(left, right);
    }

    public int move(final int index) {
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
