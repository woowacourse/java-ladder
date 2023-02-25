package domain;

import ui.output.LadderShape;
import util.RandomValueGenerator;

import java.util.*;

import static ui.output.LadderShape.*;

public class Line {

    private final List<Boolean> points = new ArrayList<>();

    public Line(int personCount) {
        calculatePoints(personCount);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    public int getSize() {
        return points.size();
    }

    private void calculatePoints(int personCount) {
        RandomValueGenerator randomValueGenerator = new RandomValueGenerator();
        points.add(randomValueGenerator.getRandomValue());
        while (personCount-- > 2) {
            if (!points.get(points.size() - 1)) {
                points.add(randomValueGenerator.getRandomValue());
                continue;
            }
            points.add(false);
        }
    }

    public boolean canGoThisPoint(int pointNumber) {
        return points.get(pointNumber);
    }
}
