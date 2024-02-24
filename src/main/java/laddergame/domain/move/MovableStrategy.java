package laddergame.domain.move;

import laddergame.domain.ladder.Line;

import java.util.Optional;

public interface MovableStrategy {
    Optional<Trace> move(Line line, int position);
}
