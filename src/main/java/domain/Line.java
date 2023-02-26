package domain;

import dto.LineDTO;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final String INVALID_BRIDGE_MESSAGE = "다리는 연속으로 생성되면 안됩니다.";
    private final List<Bridge> line;

    public Line(final List<Bridge> line) {
        for (int index = 1; index < line.size(); index++) {
            validateLine(line, index);
        }
        this.line = line;
    }

    public Direction calculateNextPosition(final int index) {
        if (isStartPosition(index)) {
            return isMovableToRight(index);
        }
        if (isLastPosition(index)) {
            return isMovableToLeft(index);
        }
        return checkNextDirection(index);
    }

    private void validateLine(final List<Bridge> line, final int index) {
        Bridge currentBridge = line.get(index);
        Bridge previousBridge = line.get(index - 1);
        if (currentBridge.isExist() && previousBridge.isExist()) {
            throw new IllegalArgumentException(INVALID_BRIDGE_MESSAGE);
        }
    }

    private boolean isStartPosition(final int index) {
        return index == 0;
    }

    private boolean isLastPosition(final int index) {
        return index == line.size();
    }

    private Direction isMovableToRight(final int index) {
        if (line.get(index) == Bridge.EXIST) {
            return Direction.RIGHT;
        }
        return Direction.DOWN;
    }

    private Direction isMovableToLeft(final int index) {
        if (line.get(index - 1) == Bridge.EXIST) {
            return Direction.LEFT;
        }
        return Direction.DOWN;
    }

    private Direction checkNextDirection(final int index) {
        if (isMovableToRight(index).equals(Direction.RIGHT)) {
            return Direction.RIGHT;
        }
        if (isMovableToLeft(index).equals(Direction.LEFT)) {
            return Direction.LEFT;
        }
        return Direction.DOWN;
    }

    public LineDTO getLineDTO() {
        List<Bridge> lineDTO = new ArrayList<>(line);
        return new LineDTO(lineDTO);
    }
}
