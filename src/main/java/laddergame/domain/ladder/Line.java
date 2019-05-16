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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Point point : line) {
            stringBuilder.append(point);
            stringBuilder.append("|");
        }
        return stringBuilder.toString();
    }

    public int findRoute(int startPosition) {
        if(checkLeft(startPosition)){
            return Constant.LEFT_MOVE;
        }
        if(checkRight(startPosition-1)){
            return Constant.RIGHT_MOVE;
        }
        return Constant.NOT_MOVE;
    }
}
