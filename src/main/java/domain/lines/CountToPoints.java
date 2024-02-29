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
        return Stream.iterate(Point.DISCONNECTED, this::nextPoint)
                .limit(source)
                .skip(1)
                .toList();
    }

    private Point nextPoint(Point prevPoint) {
        if (prevPoint.isConnected()) return Point.DISCONNECTED;
        return Point.from(generator.generate());
    }
}
