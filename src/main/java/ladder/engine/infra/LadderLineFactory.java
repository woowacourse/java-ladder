package ladder.engine.infra;

import ladder.engine.LadderLine;

import java.util.ArrayList;
import java.util.List;

import static ladder.engine.infra.RandomValueGenerator.generate;

public class LadderLineFactory {
    public static LadderLine createLine(int sizeOfPerson) {
        List<Point> points = new ArrayList<>();
        Point point = Point.first(generate());
        points.add(point);
        while(!point.isLast(sizeOfPerson)) {
            point = point.next();
            points.add(point);
        }
        return new DefaultLadderLine(points);
    }
}
