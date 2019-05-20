package ladder.domain.ladder;

import ladder.domain.rule.LadderRule;

import java.util.ArrayList;
import java.util.List;

class LineGenerator {
    static Line generate(int lineWidth, LadderRule rule) {
        List<LadderGameResult> points = new ArrayList<>();
        points.add(LadderGameResult.firstPoint(rule.isAvailablePoint()));
        for (int i = 0; i < lineWidth - 1; i++) {
            points.add(points.get(i).nextPoint(lineWidth - 1, rule.isAvailablePoint()));
        }
        return new Line(points);
    }
}
