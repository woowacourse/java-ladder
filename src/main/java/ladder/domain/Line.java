package ladder.domain;

import java.util.ArrayList;
import java.util.Objects;

public class Line {
    private static final int CONNECT_CONDITION = 5;

    private ArrayList<Boolean> points = new ArrayList<>();

    public Line(final int numberOfPeople) {
        for (int i = 0; i < numberOfPeople; i++) {
            points.add(false);
        }
    }

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

    public void connect(int point, int number) {
        if (number >= CONNECT_CONDITION) {
            points.set(point, true);
        }
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
