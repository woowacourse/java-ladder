package laddergame.domain.move;

import laddergame.domain.ladder.Line;
import laddergame.domain.point.Point;

import java.util.List;

public class Trace {
    private int position;
    private MovableStrategy movableStrategy;

    public Trace(final int position, final MovableStrategy movableStrategy) {
        this.position = position;
        this.movableStrategy = movableStrategy;
    }

    public int getPosition() {
        return position;
    }

    public MovableStrategy getMovableStrategy() {
        return movableStrategy;
    }

    public Trace next(Line line) {
        return movableStrategy.move(line, position).orElse(this);
    }
}
