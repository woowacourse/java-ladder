package laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> line;

    public Line(int width) {
        line = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            line.add(new Point(false));
        }
    }

    public void connect(int column) {
        if (!checkRight(column) && !checkLeft(column)) {
            line.set(column, new Point(true));
        }
    }

    private boolean checkRight(int column) {
        try {
            return checkRightBridge(column);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    private boolean checkLeft(int column) {
        try {
            return checkLeftBridge(column);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    private boolean checkRightBridge(int column) {
        return (line.get(column + 1).hasBridge());
    }

    private boolean checkLeftBridge(int column) {
        return (line.get(column - 1).hasBridge());
    }

    public boolean isLinked(int column) {
        return line.get(column).hasBridge();
    }

    public Direction findRoute(int startPosition) {
        if (checkLeft(startPosition)) {
            return Direction.left();
        }
        if (checkRight(startPosition - 1)) {
            return Direction.right();
        }
        return Direction.keep();
    }

    public int getWidth() {
        return (line.size() - 1);
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
