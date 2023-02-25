package ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;

/**
 * Row 를 생성하는 역할을 가진 클래스
 * <p>
 * Row 는 Point 를 가지고 있으며, Point 는 왼쪽으로 이동가능, 오른쪽으로 이동가능, 이동하지 않음 상태를 표현하고 있음
 * <p>
 * 오른쪽으로 이동 가능한 point 가 마지막에 있는 경우 왼쪽으로 이동 가능한 point 를 추가해준다. 왼쪽으로 연결되지 않아도 되는 경우 NONE 이나, 오른쪽으로 이동한 point 를 추가해준다
 */
public class RowGenerator {

    private RowGenerator() {
    }

    static List<Point> generate(int size, ConnectionJudgement connectionJudgement) {
        Point previous = Point.NONE;
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < size - 1; i++) {
            previous = previous.next(connectionJudgement);
            points.add(previous);
        }
        connectLastPoint(points);
        return points;
    }

    private static void connectLastPoint(List<Point> points) {
        int lastIndex = points.size() - 1;
        if (points.get(lastIndex) == Point.RIGHT) {
            points.add(Point.LEFT);
            return;
        }
        points.add(Point.NONE);
    }
}
