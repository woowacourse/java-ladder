package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LineGenerator {
    public Line generate(int numberOfPlayers) {
        List<Point> points = new ArrayList<>();

        Direction currentDirection = Direction.first();
        points.add(new Point(currentDirection));
        for (int i = 0; i < numberOfPlayers - 2; i++) {
            currentDirection = currentDirection.next();
            points.add(new Point(currentDirection));
        }
        points.add(new Point(currentDirection.last()));

        return new Line(points);
    }
}
