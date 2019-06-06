package ladderGame.model.ladder;

import java.util.ArrayList;
import java.util.List;

import static ladderGame.model.ladder.Direction.*;

public class Row {
    private List<Point> points;

    public Row(RandomBridgeGenerator randomBridgeGenerator, int columnNum) {
        points = new ArrayList<Point>();
        for (int i = 0; i < columnNum; i++) {
            Direction randomDirection = randomBridgeGenerator.generateRandomDirection();

            if (i > 0 && points.get(i - 1).getDirection() == RIGHT) {
                points.add(new Point(LEFT));
                continue;
            }
            if (i == columnNum - 1) {
                points.add(new Point(STRAIGHT));
                continue;
            }
            points.add(new Point(randomDirection));
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
