package ladder.generator;

import ladder.domain.Line;
import ladder.domain.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomLineGenerator implements LineGenerator {

    @Override
    public Line makeLine(int countOfPlayers) {
        return new Line(makeRandomPoints(countOfPlayers));
    }

    private List<Point> makeRandomPoints(int length) {
        List<Point> points = new ArrayList<>(Arrays.asList(Point.firstPoint()));

        for (int i = 0; i < length - 2; i++) {
            points.add(Point.nextPoint(points.get(i)));
        }
        points.add(Point.lastPoint(points.get(points.size() - 1)));

        return points;
    }
}
