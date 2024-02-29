package ladder;

import java.util.List;

public class Line {

    private final List<Point> points;

    public Line(Point... points) {
        validateConnections(points);
        this.points = List.of(points);
    }

    private void validateConnections(Point[] points) {
        for (int i = 1; i < points.length; i++) {
            if (points[i].equals(points[i-1])) {
                throw new IllegalArgumentException("양 쪽으로 연결될 수 없습니다.");
            }
        }
    }

    // 어디까지 int를 쓰고, 어디부터 Index를 써야 할까?
    public int move(int index) {
        Index currentIndex = Index.of(index);
        return points.get(index).move(currentIndex).toInt();
    }
}
