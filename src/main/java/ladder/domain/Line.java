package ladder.domain;

import java.util.List;

import static ladder.util.NotNullValidator.validateNotNull;

public class Line {
    private final List<Point> points;

    public Line(List<Point> points) {
        validateNotNull(points);
        validateNumOfPoints(points);
        this.points = points;
    }

    private void validateNumOfPoints(List<Point> points) {
        if (points.size() != Players.NUM_OF_PLAYERS) {
            throw new IllegalArgumentException("라인의 포인트 수는 플레이어 수와 같아야합니다.");
        }
    }

    public Point getPoint(Position position) {
        return points.get(position.getValue());
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + points +
                '}';
    }

    public List<Point> getPoints() {
        return points;
    }
}
