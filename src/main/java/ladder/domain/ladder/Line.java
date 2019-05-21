package ladder.domain.ladder;

import ladder.domain.rule.LadderRule;
import ladder.domain.rule.RandomPointLadderRule;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final String HORIZONTAL_LINE = "|";
    private final List<Point> points = new ArrayList<>();

    public Line(int width) {
        this(width, new RandomPointLadderRule());
    }

    public Line(final int width, final LadderRule rule) {
        generatePoints(width, rule);
    }

    private void generatePoints(int width, LadderRule rule) {
        points.add(new Point(Direction.first(rule.isAvailablePoint()), 0));
        for (int i = 0; i < width - 1; i++) {
            points.add(points.get(i).nextPoint(width - 1, rule.isAvailablePoint()));
        }
    }

    public int move(int pointIndex) {
        return points.get(pointIndex).move();
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return HORIZONTAL_LINE;
    }
}
