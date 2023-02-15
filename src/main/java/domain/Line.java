package domain;

import util.RandomValueGenerator;
import util.RandomValueGeneratorImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
public class Line {

    private final List<Boolean> points = new ArrayList<>();
    private final RandomValueGenerator randomValueGenerator;

    public Line(int personCount, RandomValueGeneratorImpl impl) {
        this.randomValueGenerator = impl;
        calculatePoints(personCount);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    private void calculatePoints(int personCount) {
        while (personCount-- > 1) {
            if (points.size() != 0 && !points.get(points.size() - 1)) {
                points.add(getRandomValue());
            } else {
                points.add(false);
            }
        }
    }

    private boolean getRandomValue() {
        return randomValueGenerator.generate();
    }
}
