package ladder.domain;

import ladder.utils.RandomValueUtils;

import java.util.ArrayList;
import java.util.Objects;

public class Line {
    private ArrayList<Boolean> points = new ArrayList<>();

    public boolean isAvailableToConnect(int point) {
        if (point == points.size() - 1) {
            return false;
        }

        if (point == 0) {
            return true;
        }

        return !isConnected(point - 1);
    }

    public boolean isConnected(int point) {
        return points.get(point);
    }

    public void connect(int point) {
        if (checkFirst(point)) return;

        if (point == points.size() - 1 || isConnected(point - 1)) {
            points.add(false);
            return;
        }

        points.add(RandomValueUtils.generate());
    }

    private boolean checkFirst(int point) {
        if (point == 0) {
            points.add(RandomValueUtils.generate());

            return true;
        }

        return false;
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
