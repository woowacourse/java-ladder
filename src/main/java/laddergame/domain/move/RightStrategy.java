package laddergame.domain.move;

import laddergame.domain.ladder.Line;

import java.util.Optional;

public class RightStrategy implements MovableStrategy {

    @Override
    public Optional<Trace> move(final Line line, final int position) {
        final int right = position + 1;

        if (right == line.getSize()) {
            return Optional.empty();
        }

        if(line.hasPoint(right)) {
            return Optional.of(new Trace(right, this));
        } else if (line.hasPoint(position)){
            return Optional.of(new Trace(position, new LeftStrategy()));
        }

        return Optional.empty();
    }
}
