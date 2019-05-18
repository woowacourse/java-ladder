package ladder.domain.ladder;

import ladder.domain.rule.LadderRule;

import java.util.ArrayList;
import java.util.List;

public class LineGenerator {
    public static Line generate(int lineWidth, LadderRule rule) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, false, rule.isAvailablePoint()));
        for (int i = 1; i < lineWidth; i++) {
            points.add(new Point(points.get(i - 1), lineWidth - 1, rule.isAvailablePoint()));
        }
        return new Line(points);
    }
}
