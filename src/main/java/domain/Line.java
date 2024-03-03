package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Line {
    private final List<Point> points;
    private final List<Boolean> canGoRights;

    private Line(List<Boolean> canGoRights) {
        validateLineSize(canGoRights);
        validateRightAfterEnd(canGoRights);
        List<Point> points = new ArrayList<>();
        addFirstPoint(points, canGoRights);
        addRemainPoints(points, canGoRights);
        this.points = Collections.unmodifiableList(points);
        this.canGoRights = Collections.unmodifiableList(canGoRights);
    }

    private void validateLineSize(List<Boolean> canGoRights2) {
        if (canGoRights2.size() == 0) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRightAfterEnd(List<Boolean> canGoRights2) {
        if (canGoRights2.get(canGoRights2.size() - 1)) {
            throw new IllegalArgumentException("오른쪽 끝에선 오른쪽으로 갈 수 없습니다.");
        }
    }

    private void addFirstPoint(List<Point> points, List<Boolean> canGoRights) {
        if (canGoRights.get(0)) {
            points.add(new Point(Direction.RIGHT, 0));
        }
        if (!canGoRights.get(0)) {
            points.add(new Point(Direction.STRAIGHT, 0));
        }
    }

    private void addRemainPoints(List<Point> points, List<Boolean> canGoRights) {
        for (int index = 1; index < canGoRights.size(); index++) {
            validateContinuousRight(index, canGoRights);
            addPoint(points, index, canGoRights);
        }
    }

    private void validateContinuousRight(int index, List<Boolean> canGoRights) {
        if (canGoRights.get(index - 1) && canGoRights.get(index)) {
            throw new IllegalArgumentException("|-----|-----| 연결 감지!");
        }
    }

    private void addPoint(List<Point> points, int index, List<Boolean> canGoRights) {
        if (canGoRights.get(index)) {
            points.add(new Point(Direction.RIGHT, index));
        }
        if (canGoRights.get(index - 1) && !canGoRights.get(index)) {
            points.add(new Point(Direction.LEFT, index));
        }
        if (!canGoRights.get(index - 1) && !canGoRights.get(index)) {
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
        return canGoRights;
    }

    public static Line of(LineGenerateStrategy lineGenerateStrategy, int lineSize) {
        List<Boolean> generate = lineGenerateStrategy.generate(lineSize);
        return Line.from(generate.toArray(Boolean[]::new));
    }

    static Line from(Boolean... canGoRights) {
        return new Line(List.of(canGoRights));
    }
}
