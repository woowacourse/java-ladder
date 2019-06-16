package ladder.model.impl;

import ladder.model.Line;

import java.util.ArrayList;
import java.util.List;

import static ladder.utils.RandomValueGenerator.generate;

public class LineFactory {
    public static Line createLine(final int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = Point.first(generate());
        points.add(point);
        while (point.isNotLast(sizeOfPerson)) {
            point = point.next();
            points.add(point);
        }
        points.add(point.last());
        return new DefaultLine(points);
    }
}
