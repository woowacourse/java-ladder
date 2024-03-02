package domain.ladder;

import domain.Point;
import domain.PointGenerator;
import domain.player.PlayerCount;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Row {
    private final List<Point> points;

    private Row(final List<Point> points) {
        this.points = points;
    }

    public static Row create(final PlayerCount playerCount, final PointGenerator pointGenerator) {
        return new Row(createPoints(playerCount, pointGenerator));
    }

    private static List<Point> createPoints(final PlayerCount playerCount, final PointGenerator pointGenerator) {
        List<Point> points = new ArrayList<>();

        for (int buildCount = 0; playerCount.isBiggerThan(buildCount); buildCount++) {
            points.add(createPoint(points, pointGenerator, playerCount));
        }
        return points;
    }

    private static Point createPoint(final List<Point> points, final PointGenerator pointGenerator,
                                     final PlayerCount playerCount) {   // TODO: 얘가 만드는 게 맞을까? 아니면 상황을 넘겨주고 point가?
        if (isFirstPoint(points)) {
            return pointGenerator.generateFirstPoint();
        }
        if (hasBeforePoint(points)) {
            return Point.left();
        }
        if (isLastPoint(points, playerCount)) {
            return pointGenerator.generateLastPoint();
        }
        return pointGenerator.generate();
    }

    private static boolean isFirstPoint(final List<Point> points) {
        return points.isEmpty();
    }

    private static boolean hasBeforePoint(final List<Point> points) {
        final int index = points.size();
        if (index == 0) {
            return false;
        }
        return points.get(index - 1).isRight();
    }

    private static boolean isLastPoint(final List<Point> points, final PlayerCount playerCount) {
        return playerCount.isSameWith(points.size() + 1);
    }

    public int playRow(final int index) {
        Point targetPoint = points.get(index);
        return targetPoint.move(index);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Row row = (Row) o;
        return Objects.equals(points, row.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
