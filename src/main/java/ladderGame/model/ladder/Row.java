package ladderGame.model.ladder;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Point> points;

    public Row(int columnNum) {
        points = new ArrayList<Point>();
        for (int i = 0; i < columnNum; i++) {
            points.add(new Point(Direction.STRAIGHT));
        }
    }

    public void draw(int column) {
        if (isRightBorder(column)) {
            return;
        }
        if (currentPointisStraight(column) && rightBridgePointisStraight(column)) {
            setDirection(column);
            return;
        }
    }

    private boolean isRightBorder(int column) {
        return column == points.size() - 1;
    }

    private void setDirection(int column) {
        setRight(column);
        setLeft(column + 1);
    }

    private void setLeft(int column) {
        points.get(column).setLeft();
    }

    private void setRight(int column) {
        points.get(column).setRight();
    }

    private boolean currentPointisStraight(int column) {
        return points.get(column).getDirection() == Direction.STRAIGHT;
    }

    private boolean rightBridgePointisStraight(int column) {
        if (column == points.size() - 1) {
            return false;
        }
        return points.get(column + 1).getDirection() == Direction.STRAIGHT;
    }

    public int getArrivalIndex(int startIndex) {
        return points.get(startIndex).getDirection().apply(startIndex);
    }

    public int getBridgeNumber() {
        return (int) points.stream()
                .filter(point -> point.getDirection() == Direction.RIGHT).count();
    }

    public Direction getDirection(int column) {
        return points.get(column).getDirection();
    }
}
