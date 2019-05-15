package ladder.domain;

import java.util.ArrayList;

public class Line {
    private ArrayList<Boolean> points = new ArrayList<>();

    public Line(final int countOfPerson) {
        for (int i = 0; i < countOfPerson; i++) {
            points.add(false);
        }
    }

    public boolean isAvailableToConnect(Point point) {
        if (point.compareToPosition(points.size()) >= 0) {
            throw new IndexOutOfBoundsException("좌표를 벗어났습니다.");
        }

        if (point.compareToPosition(points.size() - 1) == 0) {
            return false;
        }

        return !points.get(point.getPosition()) && !points.get(point.getPosition() + 1);
    }

    public void connect(int point) {
        points.add(point, true);
        points.add(point + 1, true);
    }
}
