package laddergame.domain.move;

import laddergame.domain.ladder.Line;

import java.util.Objects;

public class Trace {
    private int position;
    private MovableStrategy movableStrategy;

    public Trace(final int position, final MovableStrategy movableStrategy) {
        this.position = position;
        this.movableStrategy = movableStrategy;
    }

    public static Trace init(final int position, final MovableStrategy movableStrategy) {
        return new Trace(position, movableStrategy);
    }

    public Trace next(Line line) {
        return movableStrategy.move(line, position).orElse(this);
    }

    public int getPosition() {
        return position;
    }

    public MovableStrategy getMovableStrategy() {
        return movableStrategy;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Trace trace = (Trace) o;
        return position == trace.position && movableStrategy.getClass().equals(trace.movableStrategy.getClass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, movableStrategy);
    }
}
