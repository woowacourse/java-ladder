package laddergame.domain;

import laddergame.util.LinesGenerator;

import java.util.Collections;
import java.util.List;

public class Lines {
    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public Direction findDirection(int index) {
        if (index == 0) {
            return checkWhenFirst(index);
        }
        if (index == lines.size()) {
            return checkWhenLast(index);
        }
        return checkBeforeAndRight(index);
    }

    private Direction checkWhenFirst(int index) {
        if (lines.get(index).equals(Line.BRIDGE)) {
            return Direction.RIGHT;
        }
        return Direction.DOWN;
    }

    private Direction checkWhenLast(int index) {
        if (lines.get(index - 1).equals(Line.BRIDGE)) {
            return Direction.LEFT;
        }
        return Direction.DOWN;
    }

    private Direction checkBeforeAndRight(int index) {
        if (lines.get(index).equals(Line.BRIDGE)) {
            return Direction.RIGHT;
        }
        if (lines.get(index - 1).equals(Line.BRIDGE)) {
            return Direction.LEFT;
        }
        return Direction.DOWN;
    }
}
