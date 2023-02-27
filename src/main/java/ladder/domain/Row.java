package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Row 는 Point 를 가지고 있으며, Point 는 왼쪽으로 이동가능, 오른쪽으로 이동가능, 이동하지 않음 상태를 표현하고 있음
 * <p>
 * Point 를 받아서 현재 Point 와 연결된 Point 를 반환하는 책임을 가지고 있다
 */
public class Row {

    private static final int MINIMUM_SIZE = 2;
    private static final String SMALL_SIZE_MESSAGE = "길이는 " + MINIMUM_SIZE + " 이상이어야 합니다. 현재 : %s";

    private final List<Point> points;

    private Row(List<Point> points) {
        this.points = points;
    }

    public static Row valueOf(int size, ConnectionJudgement connectionJudgement) {
        validateMinimumSize(size);
        List<Point> row = generateRow(size, connectionJudgement);
        return new Row(row);
    }

    private static List<Point> generateRow(int size, ConnectionJudgement connectionJudgement) {
        Point previous = Point.NONE;
        List<Point> row = new ArrayList<>();
        for (int i = 0; i < size - 1; i++) {
            previous = previous.next(connectionJudgement);
            row.add(previous);
        }
        connectLastPoint(row);
        return row;
    }

    private static void connectLastPoint(List<Point> points1) {
        int lastIndex = points1.size() - 1;
        if (points1.get(lastIndex) == Point.RIGHT) {
            points1.add(Point.LEFT);
        } else {
            points1.add(Point.NONE);
        }
    }


    private static void validateMinimumSize(int size) {
        if (size < MINIMUM_SIZE) {
            throw new IllegalArgumentException(String.format(SMALL_SIZE_MESSAGE, size));
        }
    }

    List<Boolean> getPoints() {
        return points.stream()
                .map(Point::isRightConnected)
                .collect(Collectors.toList());
    }

    Position calculateNextPosition(Position position) {
        int index = position.getIndex();
        return points.get(index)
                .move(position);
    }
}
