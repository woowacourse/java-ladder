package laddergame.domain.point;

import laddergame.domain.point.Point;

@FunctionalInterface
public interface PointGenerator {

    Point generate();
}
