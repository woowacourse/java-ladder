package ladder.domain;

import java.util.Arrays;

import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Point> points;

    public Line(int personCount, Direction... directions) {
        this(personCount, Arrays.asList(directions));
    }

    public Line(int personCount, List<Direction> directions) {
        validate(personCount, directions);
        this.points = createPoints(directions);
    }

    private List<Point> createPoints(List<Direction> directions) {
        return directions.stream()
                .map(Point::new)
                .toList();
    }

    private void validate(int personCount, List<Direction> directions) {
        validateWidth(personCount, directions);
        validateStartDirection(directions);
        validateEndDirection(directions);
        validateNotOnlyDownDirection(directions);
        validateNoMismatchedDirections(directions);
    }

    private void validateWidth(int personCount, List<Direction> directions) {
        if (personCount != directions.size()) {
            throw new IllegalArgumentException("사다리 너비가 참여자 수와 같아야 합니다.");
        }
    }

    private void validateStartDirection(List<Direction> directions) {
        if (directions.get(0).isLeft()) {
            throw new IllegalArgumentException("라인의 시작 좌표가 왼쪽 방향입니다.");
        }
    }

    private void validateEndDirection(List<Direction> directions) {
        if (directions.get(directions.size() - 1).isRight()) {
            throw new IllegalArgumentException("라인의 끝 좌표가 오른쪽 방향입니다.");
        }
    }

    private void validateNotOnlyDownDirection(List<Direction> directions) {
        boolean onlyDownDirection = directions.stream().allMatch(Direction::isDown);

        if (onlyDownDirection) {
            throw new IllegalArgumentException("라인의 모든 좌표가 아래 방향입니다.");
        }
    }

    private void validateNoMismatchedDirections(List<Direction> directions) {
        for (int i = 1; i < directions.size() - 1; i++) {
            validateNotRightBeforeLeft(directions.get(i), directions.get(i - 1));
            validateNotLeftAfterRight(directions.get(i), directions.get(i + 1));
        }
    }

    private void validateNotRightBeforeLeft(Direction current, Direction previous) {
        if (current.isLeft() && !previous.isRight()) {
            throw new IllegalArgumentException("라인의 특정 왼쪽 방향 좌표의 이전 좌표가 오른쪽 방향이 아닙니다.");
        }
    }

    private void validateNotLeftAfterRight(Direction current, Direction next) {
        if (current.isRight() && !next.isLeft()) {
            throw new IllegalArgumentException("라인의 특정 오른쪽 방향 좌표의 다음 좌표가 왼쪽 방향이 아닙니다.");
        }
    }

    public Index move(Index index) {
        return points.get(index.getValue()).move(index);
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
