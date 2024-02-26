package domain.lines;

import domain.BooleanGenerator;
import domain.line.Point;

import java.util.List;
import java.util.stream.Stream;

public class CountToPoints {
    private final int source;
    private final BooleanGenerator generator;

    public CountToPoints(int source, BooleanGenerator generator) {
        this.source = source;
        this.generator = generator;
    }

    public List<Point> value() {
        final Point firstPoint = Point.from(generator.generate());
        return Stream.iterate(firstPoint, prevPoint ->
                selectCurrentPoint(generator, prevPoint)
        ).limit(source - 1).toList();
    }

    private static Point selectCurrentPoint(BooleanGenerator generator, Point prevPoint) {
        if (prevPoint.isConnected()) return Point.DISCONNECTED;
        return Point.from(generator.generate());
    }
}
