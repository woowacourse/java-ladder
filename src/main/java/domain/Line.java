package domain;

import java.util.*;
import java.util.stream.IntStream;

public class Line {
    private final List<Point> points;

    public Line(final Point... argument) {
        final List<Point> points = List.of(argument);
        validate(points);
        this.points = points;
    }

    public static Line ofDirections(final Direction... directions) {
        return new Line(Arrays.stream(directions).map(Point::new).toArray(Point[]::new));
    }

    private void validate(final List<Point> points) {
//        validateEmptiness(points);
        validateFirstPointDirection(points);
        validateLastPointDirection(points);
        validateConnection(points);
    }

    private void validateConnection(final List<Point> points) {
        for (int i = 1; i < points.size(); i++) {
            Point beforePoint = points.get(i - 1);
            Point currentPoint = points.get(i);
            if (beforePoint.invalidConnection(currentPoint)) {
                throw new IllegalArgumentException("유효한 가로선이 되려면 서로 방향이 달라야합니다");
            }
        }
    }

    private void validateFirstPointDirection(final List<Point> points) {
        final Point firstPoint = points.get(0);
        if (firstPoint.equals(new Point(Direction.LEFT))) {
            throw new IllegalArgumentException("첫번째 위치에서 왼쪽으로 연결 될 수 없습니다.");
        }
    }

    private void validateLastPointDirection(final List<Point> points) {
        final Point lastPoint = points.get(points.size() - 1);
        if (lastPoint.equals(new Point(Direction.RIGHT))) {
            throw new IllegalArgumentException("마지막 위치에서 오른쪽으로 연결 될 수 없습니다.");
        }
    }

    private void validateEmptiness(final List<Point> points) {
    }

    public Index move(final Index index) {
        Point target = points.get(index.toInt());
        return target.move(index);
    }

    public static Line generate(final int width, final RandomGenerator randomGenerator) {
        final List<Direction> directions = new ArrayList<>();

        directions.add(Direction.generateFirst(randomGenerator.next()));
        IntStream.range(1, width - 1)
                .mapToObj(i -> directions.get(i - 1))
                .forEach(beforeDirection -> directions.add(
                        Direction.generate(beforeDirection, randomGenerator.next())));
        directions.add(Direction.generateLast(directions.get(directions.size() - 1)));

        return Line.ofDirections(directions.toArray(Direction[]::new));
    }

    public List<Point> getPoints() {
        return points;
    }

    public int size() {
        return points.size();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Line other = (Line) o;
        return points.equals(other.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
