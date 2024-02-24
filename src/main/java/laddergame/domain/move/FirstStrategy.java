package laddergame.domain.move;

import laddergame.domain.ladder.Line;

import java.util.Optional;

public class FirstStrategy implements MovableStrategy{

    @Override
    public Optional<Trace> move(final Line line, final int position) {
        if (line.hasPoint(position)) {
            return Optional.of(new Trace(position, new RightStrategy()));
        }

        if (line.hasPoint(position - 1)) {
            return Optional.of(new Trace(position - 1, new LeftStrategy()));
        }

        return Optional.empty();
    }
}
