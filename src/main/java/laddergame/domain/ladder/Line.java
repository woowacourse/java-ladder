package laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Point> line;

    public Line(final int width) {
        line = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            line.add(new Point(false));
        }
    }

    public boolean connect(int column) {
        if (!checkRight(column) && !checkLeft(column)) {
            line.set(column, new Point(true));
            return true;
        }
        return false;
    }

    private boolean checkRight(int column) {
        try {
            return (line.get(column + 1).hasBridge());
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    private boolean checkLeft(int column) {
        try {
            return (line.get(column - 1).hasBridge());
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public Direction findPosition(int startPosition) {
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
