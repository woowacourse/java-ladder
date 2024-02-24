package laddergame.domain.move;

import laddergame.domain.point.Point;

import java.util.List;
import java.util.Optional;

public class RightStrategy implements MovableStrategy {

    @Override
    public Optional<Trace> move(final List<Point> points, final int position) {
        final int right = position + 1;

        if (right > points.size()) {
            return Optional.empty();
        }

        if(points.get(right).isExist()) {
            return Optional.of(new Trace(right, this));
        } else if (points.get(position).isExist()){
            return Optional.of(new Trace(position, new LeftStrategy()));
        }

        return Optional.empty();
    }
}
