package ladder.domain.ladder;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Line {
    private static final int MIN_LINE_WIDTH = 2;

    private final List<Point> points;

    public Line(List<Point> points) {
        validateLineWidth(points.size());
        this.points = points;
    }

    private void validateLineWidth(int width) {
        if (width < MIN_LINE_WIDTH) {
            throw new IllegalArgumentException("라인의 길이는 " + MIN_LINE_WIDTH + " 이상입니다.");
        }
    }

    public int move(int point) {
        return points.get(point).nextPointPosition();
    }

    public List<PointDTO> getPointDTO() {
        return points.stream().map(PointDTO::new).collect(Collectors.toList());
    }

    public int width() {
        return points.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        System.out.println("1 : " + points.equals(line.points));
        return points.equals(line.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
