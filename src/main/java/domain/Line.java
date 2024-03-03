package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Line {
    private final List<Point> points;
    private final Boolean[] canGoRights;

    Line(Boolean... canGoRights) {
        validateLineSize(canGoRights);
        validateRightAfterEnd(canGoRights);
        List<Point> points = new ArrayList<>();
        addFirstPoint(points, canGoRights);
        addRemainPoints(points, canGoRights);
        this.points = Collections.unmodifiableList(points);
        this.canGoRights = canGoRights;
    }

    public static Line of(LineGenerateStrategy lineGenerateStrategy, int lineSize) {
        List<Boolean> generate = lineGenerateStrategy.generate(lineSize);
        return new Line(generate.toArray(Boolean[]::new));
    }

    private void validateLineSize(Boolean[] canGoRights) {
        if (canGoRights.length == 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRightAfterEnd(Boolean[] canGoRights) {
        if (canGoRights[canGoRights.length - 1]) {
            throw new IllegalArgumentException("오른쪽 끝에선 오른쪽으로 갈 수 없습니다.");
        }
    }

    private void addFirstPoint(List<Point> points, Boolean[] canGoRights) {
        if (canGoRights[0]) {
            points.add(new Point(Direction.RIGHT, 0));
        }
        if (!canGoRights[0]) {
            points.add(new Point(Direction.STRAIGHT, 0));
        }
    }

    private void addRemainPoints(List<Point> points, Boolean[] canGoRights) {
        for (int index = 1; index < canGoRights.length; index++) {
            validateContinuousRight(index, canGoRights);
            addPoint(points, index, canGoRights);
        }
    }

    private void validateContinuousRight(int index, Boolean[] canGoRights) {
        if (canGoRights[index - 1] && canGoRights[index]) {
            throw new IllegalArgumentException("|-----|-----| 연결 감지!");
        }
    }

    private void addPoint(List<Point> points, int index, Boolean[] canGoRights) {
        if (canGoRights[index]) {
            points.add(new Point(Direction.RIGHT, index));
        }
        if (canGoRights[index - 1] && !canGoRights[index]) {
            points.add(new Point(Direction.LEFT, index));
        }
        if (!canGoRights[index - 1] && !canGoRights[index]) {
            points.add(new Point(Direction.STRAIGHT, index));
        }
    }

    int length() {
        return points.size();
    }

    boolean isConnectWithNextPoint(int index) {
        if (index == points.size() - 1) {
            return false;
        }
        Point point = points.get(index);
        Point nextPoint = points.get(index + 1);
        return point.next().equals(nextPoint);
    }

    int move(int startIndex) {
        Point start = points.get(startIndex);
        Point next = start.next();
        return next.index();
    }

    List<Boolean> getRawLine() {
        return List.of(canGoRights);
    }
}
