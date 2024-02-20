package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Direction> points;

    public Line(int participantCount) {
        this.points = new ArrayList<>();
    }

    public boolean checkIsPossibleAddBridge(int position) {
        // TODO: 간소화 시킬 수 있을지 고민해보기
        return !points.get(position - 1).equals(Direction.RIGHT);
    }

    public List<Direction> getPoints() {
        return points;
    }
}
