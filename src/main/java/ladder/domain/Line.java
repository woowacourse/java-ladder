package ladder.domain;

import ladder.util.BooleanListGenerator;

import java.util.List;

public class Line {

    private final List<Boolean> points;

    public Line(int personCount, BooleanListGenerator booleanListGenerator) {
        this.points = booleanListGenerator.generate(personCount - 1);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
