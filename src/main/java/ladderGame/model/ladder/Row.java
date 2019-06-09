package ladderGame.model.ladder;

import ladderGame.model.ladder.direction.Direction;
import ladderGame.model.ladder.direction.DirectionGenerator;

import java.util.ArrayList;
import java.util.List;

import static ladderGame.model.ladder.direction.Direction.*;

public class Row {
    private List<Point> points;

    public Row(DirectionGenerator directionGenerator, int columnNum) {
        points = new ArrayList<Point>();
        for (int i = 0; i < columnNum; i++) {
            Direction direction = directionGenerator.generateDirection();

            if (i > 0 && points.get(i - 1).getDirection() == RIGHT) {
                points.add(new Point(LEFT));
                continue;
            }
            if (i == columnNum - 1) {
                points.add(new Point(STRAIGHT));
                continue;
            }
            points.add(new Point(direction));
        }
    }

    public int getArrivalIndex(int startIndex) {
        return points.get(startIndex).getDirection().apply(startIndex);
    }

    public int getBridgeNumber() {
        return (int) points.stream()
                .filter(point -> point.getDirection() == RIGHT).count();
    }

    public Direction getDirection(int column) {
        return points.get(column).getDirection();
    }
}
