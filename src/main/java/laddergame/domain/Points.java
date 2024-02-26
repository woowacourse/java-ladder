package laddergame.domain;

import java.util.List;

public record Points(List<Point> points) {
    public boolean isPositionBuilt(final int position) {
        return points.get(position).isBuilt();
    }

    public boolean isFirstPointBuilt() {
        return isPositionBuilt(0);
    }

    public boolean isLastPointBuilt() {
        return isPositionBuilt(points.size() - 1);
    }

    public int getPointSize() {
        return points.size();
    }
}
