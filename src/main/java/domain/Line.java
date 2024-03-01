package domain;

import domain.generator.RandomGenerator;
import java.util.*;
import java.util.stream.IntStream;

public class Line {
    private final List<Point> points;

    public Line(final List<Point> points) {
        validate(points);
        this.points = points;
    }

    public static Line ofDirections(final Direction... directions) {
        return new Line(
                Arrays.stream(directions)
                        .map(Point::new)
                        .toList()
        );
    }

    private void validate(final List<Point> points) {
        validateEmptiness(points);
        validateFirstPointDirection(points.get(0));
        validateLastPointDirection(points.get(points.size() - 1));

        IntStream.range(1, points.size()).forEach(index -> {
            Point beforePoint = points.get(index - 1);
            Point currentPoint = points.get(index);
            validateConnection(beforePoint, currentPoint);
        });
    }

    private void validateConnection(final Point beforePoint, final Point currentPoint) {
        if (beforePoint.invalidConnection(currentPoint)) {
            throw new IllegalArgumentException("유효한 가로선이 되려면 서로 방향이 달라야합니다");
        }
    }

    private void validateFirstPointDirection(final Point firstPoint) {
        if (firstPoint.equals(new Point(Direction.LEFT))) {
            throw new IllegalArgumentException("첫번째 위치에서 왼쪽으로 연결 될 수 없습니다.");
        }
    }

    private void validateLastPointDirection(final Point lastPoint) {
        if (lastPoint.equals(new Point(Direction.RIGHT))) {
            throw new IllegalArgumentException("마지막 위치에서 오른쪽으로 연결 될 수 없습니다.");
        }
    }

    private void validateEmptiness(final List<Point> points) {
        if (points.isEmpty()) {
            throw new IllegalArgumentException("사다리는 비어있을 수 없습니다.");
        }
    }

    public Index move(final Index index) {
        final Point target = points.get(index.toInt());
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
