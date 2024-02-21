package ladder.domain;

import ladder.util.BooleanListGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private final List<Boolean> points;
    private final BooleanListGenerator booleanListGenerator;

    public Line(int personCount, BooleanListGenerator booleanListGenerator) {
        this.booleanListGenerator = booleanListGenerator;
        this.points = createValidPoints(personCount - 1);
    }

    private List<Boolean> createValidPoints(int size) {
        List<Boolean> points = booleanListGenerator.generate(size);
        if (!points.contains(true)) {
            return createValidPoints(size);
        }
        for (int i = 1; i < points.size(); i++) {
            replaceValidPoint(points, i);
        }
        return points;
    }

    private void replaceValidPoint(List<Boolean> points, int i) {
        if (points.get(i - 1)) {
            points.set(i, false);
        }
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public String createValidPoints(boolean point) {
        if (point) {
            return "-".repeat(5);
        }
        return " ".repeat(5);
    }

    @Override
    public String toString() {
        return points.stream()
                .map(this::createValidPoints)
                .collect(Collectors.joining("|", "    |", "|"));
    }

}
