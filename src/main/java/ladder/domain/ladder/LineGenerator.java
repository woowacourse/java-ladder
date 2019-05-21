package ladder.domain.ladder;

import ladder.domain.rule.LadderRule;

import java.util.ArrayList;
import java.util.List;

class LineGenerator {
    static Line generate(final int lineWidth, final LadderRule rule) {
        List<Point> points = new ArrayList<>();
        points.add(Point.firstPoint(rule.isAvailablePoint()));
        for (int i = 0; i < lineWidth - 1; i++) {
            points.add(points.get(i).nextPoint(lineWidth - 1, rule.isAvailablePoint()));
        }
        return new Line(points);
    }
}
