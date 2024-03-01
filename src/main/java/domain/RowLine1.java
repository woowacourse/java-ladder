package domain;

import java.util.List;

public class RowLine1 {

    private final List<Point> points;

    public RowLine1(List<Point> points) {
        this.points = points;
    }

    public ColumnPosition nextPosition(ColumnPosition columnPosition) {
        Point point = getPointByColumnPosition(columnPosition);
        return columnPosition.nextPosition(point.getConnection().getDirection());
    }

    public Point getPointByColumnPosition(ColumnPosition columnPosition) {
        return points.stream()
                .filter(point -> point.getColumnPosition().equals(columnPosition))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 위치를 가지는 지점을 찾을 수 없습니다"));
    }
}
