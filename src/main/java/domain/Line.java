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

    private void validateLine(final List<Bridge> line, final int index) {
        Bridge currentBridge = line.get(index);
        Bridge previousBridge = line.get(index - 1);
        if (currentBridge.isExist() && previousBridge.isExist()) {
            throw new IllegalArgumentException(INVALID_BRIDGE_MESSAGE);
        }
    }

    public int calculateNextPosition(final int index) {
        if (index == 0) {
            return index + checkRight(index).getDirection();
        }
        if (index == line.size()) {
            return index + checkLeft(index).getDirection();
        }
        return index + checkLeft(index).getDirection() + checkRight(index).getDirection();
    }
    private Direction checkRight(final int index) {
        if (line.get(index) == Bridge.EXIST) {
            return Direction.RIGHT;
        }
        return Direction.DOWN;
    }

    private Direction checkLeft(final int index) {
        if (line.get(index - 1) == Bridge.EXIST) {
            return Direction.LEFT;
        }
        return Direction.DOWN;
    }

    public List<Bridge> getLine() {
        return new ArrayList<>(line);
    }

    public LineDTO getLineDTO() {
        List<Bridge> lineDTO = new ArrayList<>(line);
        return new LineDTO(lineDTO);
    }
}
