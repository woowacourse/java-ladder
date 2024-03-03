package laddergame.domain.strategy;

import laddergame.domain.Direction;
import laddergame.domain.Line;
import laddergame.domain.Rung;

import java.util.List;

public interface FindDirectionStrategy {
    Direction nextDirection(Rung leftRung, Rung rightRung);
}
