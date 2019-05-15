package ladder.domain;

import java.util.ArrayList;
import java.util.Objects;

public class Line {
    private static final int CONNECT_CONDITION = 4;

    private ArrayList<Boolean> points = new ArrayList<>();

    public Line(final int countOfPerson) {
        for (int i = 0; i < countOfPerson; i++) {
            points.add(false);
        }
    }

    public boolean isAvailableToConnect(int point) {
        if (point >= points.size()) {
            throw new IndexOutOfBoundsException("좌표를 벗어났습니다.");
        }

        if (point == points.size() - 1) {
            return false;
        }

        return !points.get(point) && !points.get(point + 1);
    }

    public void connect(int point, int number) {
        if (number >= CONNECT_CONDITION) {
            points.add(point, true);
            points.add(point + 1, true);
        }
    }

    public boolean isConnected(int point) {
        return points.get(point);
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
