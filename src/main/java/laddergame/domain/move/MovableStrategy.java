package laddergame.domain.move;

import laddergame.domain.point.Point;

import java.util.List;
import java.util.Optional;

public interface MovableStrategy {
    Optional<Trace> move(List<Point> points, int position);
}
