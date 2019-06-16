package ladder.model.impl;

import ladder.model.Line;

import java.util.ArrayList;
import java.util.List;

class DefaultLine implements Line {
    private final List<Point> points;

    DefaultLine(List<Point> points) {
        this.points = points;
    }

    @Override
    public int move(int position) {
        return points.get(position).move();
    }

    public List<Boolean> getHorizontalPattern() {
        List<Boolean> pattern = new ArrayList<>();
        for (Point point : points) {
            pattern.add(point.isCurrent());
        }
        return pattern;
    }

    @Override
    public String toString() {
        return "DefaultLine{" +
                "points=" + points +
                '}';
    }
}

