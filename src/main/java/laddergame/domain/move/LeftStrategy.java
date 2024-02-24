package laddergame.domain.move;

import laddergame.domain.point.Point;

import java.util.List;
import java.util.Optional;

public class LeftStrategy implements MovableStrategy {
    @Override
    public Optional<Trace> move(final List<Point> points, final int position) {
        final int left = position - 1;

        if (left < 0) {
            return Optional.empty();
        }

        if (points.get(left).isExist()) {
            return Optional.of(new Trace(left, this));
        } else if(points.get(position).isExist()){
            return Optional.of(new Trace(position, new RightStrategy()));
        }

        return Optional.empty();
    }
}
