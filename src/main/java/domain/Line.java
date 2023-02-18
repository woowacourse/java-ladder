package domain;

import util.RandomValueGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> points = new ArrayList<>();
    private final RandomValueGenerator randomValueGenerator;

    public Line(int personCount) {
        this.randomValueGenerator = new RandomValueGenerator();
        calculatePoints(personCount);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    private void calculatePoints(int personCount) {
        points.add(getRandomValue());
        while (personCount-- > 2) {
            if (!points.get(points.size() - 1)) {
                points.add(getRandomValue());
                continue;
            }
            points.add(false);
        }
    }

    private boolean getRandomValue() {
        return randomValueGenerator.generate();
    }
}
