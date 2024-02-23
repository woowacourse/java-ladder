package domain.line;

import domain.BooleanGenerator;

import java.util.List;
import java.util.stream.Stream;

public class Line {
    private final Points points;
    private final BooleanGenerator generator;

    public Line(final int personCount, final BooleanGenerator generator) {
        this.generator = generator;
        points = new CountToPoints(personCount);
    }

    public List<Point> getPoints() {
        return points.value(generator);
    }
}
