package laddergame.domain.ladder;

import laddergame.domain.Constant;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Point> line;

    public Line(int width) {
        line = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            line.add(new Point(false));
        }
    }

    public void connect(int column) {
        if (!hasBridgeAtRightSide(column) && !hasBridgeAtLeftSide(column)) {
            line.set(column, new Point(true));
        }
    }

    private boolean hasBridgeAtRightSide(int column) {
        try {
            return line.get(column + 1).hasBridge();
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    private boolean hasBridgeAtLeftSide(int column) {
        try {
            return line.get(column - 1).hasBridge();
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public boolean isLinked(int column) {
        return line.get(column).hasBridge();
    }

    public int findRoute(int startPosition) {
        if (hasBridgeAtLeftSide(startPosition + 1)) {
            return Constant.LEFT_MOVE;
        }
        if (hasBridgeAtRightSide(startPosition)) {
            return Constant.RIGHT_MOVE;
        }
        return Constant.NOT_MOVE;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Point point : line) {
            stringBuilder.append(point);
            stringBuilder.append("|");
        }
        return stringBuilder.toString();
    }
}
