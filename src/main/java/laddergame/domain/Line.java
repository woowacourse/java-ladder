package laddergame.domain;

import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Rung> rungs;

    public Line(List<Rung> rungs) {
        this.rungs = rungs;
    }

    public List<Rung> getLine() {
        return Collections.unmodifiableList(rungs);
    }

    public Direction findDirection(int index) {
        if (index == 0) {
            return checkWhenFirst(index);
        }
        if (index == rungs.size()) {
            return checkWhenLast(index);
        }
        return checkBeforeAndRight(index);
    }

    private Direction checkWhenFirst(int index) {
        if (rungs.get(index).equals(Rung.BRIDGE)) {
            return Direction.RIGHT;
        }
        return Direction.DOWN;
    }

    private Direction checkWhenLast(int index) {
        if (rungs.get(index - 1).equals(Rung.BRIDGE)) {
            return Direction.LEFT;
        }
        return Direction.DOWN;
    }

    private Direction checkBeforeAndRight(int index) {
        if (rungs.get(index).equals(Rung.BRIDGE)) {
            return Direction.RIGHT;
        }
        if (rungs.get(index - 1).equals(Rung.BRIDGE)) {
            return Direction.LEFT;
        }
        return Direction.DOWN;
    }
}
