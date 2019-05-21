package laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final int RIGHT_MOVE = 1;
    private static final int LEFT_MOVE = -1;
    private static final int NOT_MOVE = 0;

    private List<Point> points;

    public Line(int width) {
        points = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            points.add(new Point(false));
        }
    }

    public void connect(int column) {
        if (!hasBridgeAtRightSide(column) && !hasBridgeAtLeftSide(column)) {
            points.set(column, new Point(true));
        }
    }

    private boolean hasBridgeAtRightSide(int column) {
        try {
            return points.get(column + 1).hasBridge();
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    private boolean hasBridgeAtLeftSide(int column) {
        try {
            return points.get(column - 1).hasBridge();
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public boolean isLinked(int column) {
        return points.get(column).hasBridge();
    }

    public int findRoute(int startPosition) {
        if (hasBridgeAtLeftSide(startPosition + 1)) {
            return LEFT_MOVE;
        }
        if (hasBridgeAtRightSide(startPosition)) {
            return RIGHT_MOVE;
        }
        return NOT_MOVE;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Point point : points) {
            stringBuilder.append(point);
            stringBuilder.append("|");
        }
        return stringBuilder.toString();
    }
}
