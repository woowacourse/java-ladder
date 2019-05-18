package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public boolean isConnected(int point) {
        if (point >= points.size()) {
            return false;
        }

        return points.get(point);
    }

    public void connect(LadderBuildingStrategy strategy, int point) {
        if (!isAvailableToConnect(point)) {
            points.add(false);

            return;
        }

        points.add(strategy.generate());
    }

    private boolean isAvailableToConnect(int point) {
        if (point == points.size() - 1) {
            return false;
        }

        if (point == 0) {
            return true;
        }

        return !isConnected(point - 1);
    }

    public int getNumberOfPeople() {
        return points.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
