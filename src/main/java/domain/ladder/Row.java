package domain.ladder;

import domain.player.PlayerCount;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.BooleanSupplier;

public class Row {
    private final List<Point> points;

    private Row(final List<Point> points) {
        this.points = points;
    }

    public static Row create(final PlayerCount playerCount, final BooleanSupplier booleanSupplier) {
        return new Row(createPoints(playerCount, booleanSupplier));
    }

    private static List<Point> createPoints(final PlayerCount playerCount, final BooleanSupplier booleanSupplier) {
        List<Point> points = new ArrayList<>();

        for (int buildCount = 0; playerCount.isBiggerThan(buildCount); buildCount++) {
            points.add(Point.create(booleanSupplier, playerCount, points));
        }
        return points;
    }

    public int playRow(final int index) {
        final Point targetPoint = points.get(index);
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
