package laddergame.domain.strategy;

import laddergame.domain.Direction;
import laddergame.domain.Rung;

public interface FindDirectionStrategy {
    Direction nextDirection(Rung leftRung, Rung rightRung);
}
