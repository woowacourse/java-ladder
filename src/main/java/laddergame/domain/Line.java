package laddergame.domain;

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
        checkLeft(column);
        checkRight(column);
        line.set(column, new Point(true));
    }

    private void checkRight(int column) {
        try {
            checkRightBridge(column);
        } catch (IndexOutOfBoundsException e) {
        }
    }

    private void checkLeft(int column) {
        try {
            checkLeftBridge(column);
        } catch (IndexOutOfBoundsException e) {
        }
    }

    private void checkRightBridge(int column) {
        if (line.get(column + 1).hasBridge()) {
            throw new IllegalArgumentException("오른쪽에 중복");
        }
    }

    private void checkLeftBridge(int column) {
        if (line.get(column - 1).hasBridge()) {
            throw new IllegalArgumentException("왼쪽에 중복");
        }
    }

    public boolean isLinked(int column) {
        return line.get(column).hasBridge();
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
