package laddergame.domain;

import laddergame.domain.strategy.FindDirectionStrategy;
import laddergame.domain.strategy.FirstLineDirection;
import laddergame.domain.strategy.LastLineDirection;
import laddergame.domain.strategy.MiddleLineDirection;

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
            return applyStrategy(new FirstLineDirection(), Rung.EMPTY, rungs.get(index));
        }
        if (index == rungs.size()) {
            return applyStrategy(new LastLineDirection(), rungs.get(index - 1), Rung.EMPTY);
        }
        return applyStrategy(new MiddleLineDirection(), rungs.get(index - 1), rungs.get(index));
    }

    private Direction applyStrategy(FindDirectionStrategy findDirectionStrategy, Rung leftRung, Rung rightRung) {
        return findDirectionStrategy.nextDirection(leftRung, rightRung);
    }
}
