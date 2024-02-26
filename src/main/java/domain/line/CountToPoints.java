package domain.line;

import domain.BooleanGenerator;

import java.util.List;
import java.util.stream.Stream;

public class CountToPoints implements Points {
    private final int source;

    public CountToPoints(int source) {
        this.source = source;
    }

    @Override
    public List<Point> value(BooleanGenerator generator) {
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
