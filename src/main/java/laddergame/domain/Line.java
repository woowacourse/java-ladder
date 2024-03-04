package laddergame.domain;

import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Rung> rungs;

    public Line(final List<Rung> rungs) {
        this.rungs = rungs;
    }

    public List<Rung> getLine() {
        return Collections.unmodifiableList(rungs);
    }

    public Direction findDirection(int index) {
        if (index == 0) {
            return findFirstIndexDirection(rungs.get(index));
        }
        if (index == rungs.size()) {
            return findLastIndexDirection(rungs.get(index - 1));
        }
        return findMiddleIndexDirection(rungs.get(index - 1), rungs.get(index));
    }

    private Direction findFirstIndexDirection(Rung rightRung) {
        if (rightRung.equals(Rung.BRIDGE)) {
            return Direction.RIGHT;
        }
        return Direction.DOWN;
    }

    private Direction findLastIndexDirection(Rung leftRung) {
        if (leftRung.equals(Rung.BRIDGE)) {
            return Direction.LEFT;
        }
        return Direction.DOWN;
    }

    private Direction findMiddleIndexDirection(Rung leftRung, Rung rightRung) {
        if (leftRung.equals(Rung.BRIDGE)) {
            return Direction.LEFT;
        }
        if (rightRung.equals(Rung.BRIDGE)) {
            return Direction.RIGHT;
        }
        return Direction.DOWN;
    }
}
