package domain;

import java.util.List;
import java.util.stream.Stream;

public class Line {
    private final List<Point> points;
    private final BooleanGenerator generator;

    public Line(final int personCount, final BooleanGenerator generator) {
        this.generator = generator;
        points = createLine(personCount);
    }

    private List<Point> createLine(int personCount) {
        Point firstPoint = Point.from(generator.generate());
        return Stream.iterate(firstPoint, prevPoint -> {
            if (firstPoint.isConnected()) return Point.DISCONNECTED;
            return Point.from(generator.generate());
        }).limit(personCount - 1).toList();
    }

    public List<Point> getPoints() {
        return points;
    }
}
