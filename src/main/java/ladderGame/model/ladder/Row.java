package ladderGame.model.ladder;

import ladderGame.model.ladder.Point;

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
        if(leftisSetTrue(column) || rightisSetTrue(column)) {
            return;
        }
        points.get(column).setTrue();
    }

    private boolean leftisSetTrue(int column) {
        return column > 0 && points.get(column - 1).isTrue();

    }

    private boolean rightisSetTrue(int column) {
        return column < points.size() - 1 && points.get(column + 1).isTrue();
    }

    public boolean getPoint(int column) {
        return points.get(column).isTrue();
    }

    public int getArrivalIndex (int startIndex) {
        if(startIndex > 0 && points.get(startIndex - 1).isTrue()) {
            return startIndex - 1;
        }
        if(startIndex < points.size() && points.get(startIndex).isTrue()) {
            return startIndex + 1;
        }
        return startIndex;
    }

    public int getTruePointNumber() {
        return (int)points.stream().filter(point -> point.isTrue()).count();
    }
}
