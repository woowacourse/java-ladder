package ladder.domain;

import static ladder.domain.RowGenerator.generate;

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
        return new Row(generate(size, connectionJudgement));
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
