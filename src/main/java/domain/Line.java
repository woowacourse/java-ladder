package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Point> points;

    public Line(Boolean... canGoRights) {
        List<Point> points = new ArrayList<>();
        if (canGoRights.length == 0) {
            throw new IllegalArgumentException();
        }
        if (canGoRights[0]) {
            points.add(new Point(Direction.RIGHT, 0));
        }
        if (canGoRights[canGoRights.length - 1]) {
            throw new IllegalArgumentException("오른쪽 끝에선 오른쪽으로 갈 수 없습니다.");
        }
        for (int index = 1; index < canGoRights.length; index++) {
            if (canGoRights[index]) {
                points.add(new Point(Direction.RIGHT, index));
            }
            if (canGoRights[index - 1] && canGoRights[index]) {
                throw new IllegalArgumentException("|-----|-----| 연결 감지!");
            }
            if (canGoRights[index - 1] && !canGoRights[index]) {
                points.add(new Point(Direction.LEFT, index));
            }
            if (!canGoRights[index - 1] && !canGoRights[index]) {
                points.add(new Point(Direction.STRAIGHT, index));
            }
        }
        this.points = Collections.unmodifiableList(points);
    }
}
