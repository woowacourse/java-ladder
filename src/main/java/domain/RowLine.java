package domain;

import java.util.List;

public class RowLine {

    private final List<Point> points;

    public RowLine(List<Point> points) {
        this.points = points;
    }

    public ColumnPosition nextPosition(ColumnPosition columnPosition) {
        return getPointAt(columnPosition).navigateNextPosition();
    }

    public Point getPointAt(ColumnPosition columnPosition) {
        return points.stream()
                .filter(point -> point.getColumnPosition().equals(columnPosition))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 위치를 가지는 지점을 찾을 수 없습니다"));
    }

    public int getPointCount() {
        return points.size();
    }
}
