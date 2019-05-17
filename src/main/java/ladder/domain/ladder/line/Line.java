package ladder.domain.ladder.line;

import ladder.domain.rule.LadderRule;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> points = new ArrayList<>();

    public Line(int width, LadderRule rule) {
        generatePoints(width, rule);
    }

    private void generatePoints(int width, LadderRule rule) {
        boolean before = false;
        for (int i = 0; i < width - 1; i++) {
            points.add(!before && rule.isAvailablePoint());
            before = points.get(i);
        }
        points.add(false);
    }

    public int move(int point) {
        if (point > 0 && points.get(point - 1)) {
            return point - 1;
        }
        if (points.get(point)) {
            return point + 1;
        }
        return point;
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
