package domain;

import java.util.List;
import java.util.stream.Stream;

public class Line {
    private final List<Boolean> points;
    private final BooleanGenerator generator;

    public Line(final int personCount, final BooleanGenerator generator) {
        this.generator = generator;
        points = createLine(personCount);
    }

    private List<Boolean> createLine(int personCount) {
        Boolean firstPoint = generator.generate();
        return Stream.iterate(firstPoint, prevPoint -> {
            if (prevPoint) return false;
            return generator.generate();
        }).limit(personCount - 1).toList();
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
