package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 50;
    private static final String INVALID_HEIGHT_MESSAGE = "사다리 높이는 %d부터 %d까지 입니다.";

    private final List<Line> lines = new ArrayList<>();

    public Ladder(int height, int width, RandomGenerator generator) {
        validateHeight(height);
        addLine(height, width, generator);
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException(
                    String.format(INVALID_HEIGHT_MESSAGE, MIN_HEIGHT, MAX_HEIGHT));
        }
    }

    private void addLine(int height, int width, RandomGenerator generator) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(width, generator));
        }
    }

    public Position move(Line line, Position position) {
        if (moveRight(line, position)) {
            return position;
        }
        moveLeft(line, position);
        return position;
    }

    private boolean moveRight(Line line, Position position) {
        if (position.getIndex() == line.getPointsSize()) {
            return false;
        }
        if (line.isMovablePoint(position.getIndex())) {
            position.moveRight();
            return true;
        }
        return false;
    }
    private boolean moveLeft(Line line, Position position) {
        if (position.getIndex() == 0) {
            return false;
        }
        if (line.isMovablePoint(position.getIndex() - 1)) {
            position.moveLeft();
            return true;
        }
        return false;
    }

    public List<Line> getLines() {
        return lines;
    }

}
