package ladderGame.model.ladder;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Point> points;

    public Row(int columnNum) {
        points = new ArrayList<Point>();
        for (int i = 0; i < columnNum; i++) {
            points.add(new Point(false));
        }
    }

    public void draw(int column) {
        if (leftBridgePointisStraight(column) && rightBridgePointisStraight(column)) {
            setDirection(column);
            return;
        }
        return;
    }

    private void setDirection(int column) {
        if (column < points.size() - 1) {
            setRight(column);
            setLeft(column + 1);
        }
    }

    private void setLeft(int column) {
        points.get(column).setLeft();
    }

    private void setRight(int column) {
        points.get(column).setRight();
    }

    private boolean leftBridgePointisStraight(int column) {
        if (column == 0) {
            return false;
        }
        return points.get(column - 1).getDirection() == Direction.STRAIGHT;
    }

    private boolean rightBridgePointisStraight(int column) {
        if (column == points.size() - 1) {
            return false;
        }
        return points.get(column + 1).getDirection() == Direction.STRAIGHT;
    }

    public boolean getBridgePointExistence(int column) {
        return points.get(column).isTrue();
    }

    public int getArrivalIndex(int startIndex) {
        return points.get(startIndex).getDirection().apply(startIndex);
    }

    public int getBridgeNumber() {
        return (int) points.stream()
                .filter(point -> point.getDirection() == Direction.RIGHT).count();
    }

}
