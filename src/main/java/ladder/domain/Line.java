package ladder.domain;

import ladder.util.BooleanListGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private final List<Boolean> points;
    private final BooleanListGenerator booleanListGenerator;

    public Line(int personCount, BooleanListGenerator booleanListGenerator) {
        List<Boolean> points = booleanListGenerator.generate(personCount - 1);
        this.booleanListGenerator = booleanListGenerator;
        this.points = temp(points);

    }

    private List<Boolean> temp(List<Boolean> points) {
        if (!points.contains(true)) {
            return temp(booleanListGenerator.generate(points.size()));
        }
        for (int i = 1; i < points.size(); i++) {
            if (points.get(i - 1)) {
                points.set(i, false);
            }
        }
        return points;
    }

    public void generate(BooleanListGenerator booleanListGenerator) {

    }

    public List<Boolean> getPoints() {
        return points;
    }

    public String temp(boolean point) {
        if (point) {
            return "-".repeat(5);
        }
        return " ".repeat(5);
    }

    @Override
    public String toString() {
        return points.stream()
                .map(this::temp)
                .collect(Collectors.joining("|", "    |", "|"));
    }
}
