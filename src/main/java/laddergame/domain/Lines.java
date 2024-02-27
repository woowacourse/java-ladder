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
            if (lines.get(index).equals(Line.BRIDGE)) {
                return Direction.RIGHT;
            }
            return Direction.DOWN;
        }
        if (index == lines.size()) {
            if (lines.get(index - 1).equals(Line.BRIDGE)) {
                return Direction.LEFT;
            }
            return Direction.DOWN;
        }
        if (lines.get(index).equals(Line.BRIDGE)) {
            return Direction.RIGHT;
        }
        if (lines.get(index-1).equals(Line.BRIDGE)) {
            return Direction.LEFT;
        }
        return Direction.DOWN;
    }
}
