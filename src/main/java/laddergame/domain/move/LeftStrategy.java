package laddergame.domain.move;

import laddergame.domain.ladder.Line;

import java.util.Optional;

public class LeftStrategy implements MovableStrategy {

    @Override
    public Optional<Trace> move(final Line line, final int position) {
        final int left = position - 1;

        if (line.hasPoint(left)) {
            return Optional.of(new Trace(left, this));
        }

        if (line.hasPoint(position)) {
            return Optional.of(new Trace(position, new RightStrategy()));
        }

        return Optional.empty();
    }
}
