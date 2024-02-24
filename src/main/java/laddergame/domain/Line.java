package laddergame.domain;

import java.util.List;

import laddergame.domain.strategy.LineBuildStrategy;

public class Line {
    private List<Boolean> points;

    public Line(final List<Boolean> points) {
        this.points = points;
    }

    public static Line buildOf(final LineBuildStrategy lineBuildStrategy,
                               final int width)
    {
        return new Line(lineBuildStrategy.apply(width));
    }

    public boolean isBuilt(final int position) {
        return points.get(position);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
