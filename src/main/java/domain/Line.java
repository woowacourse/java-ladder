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

    public Line(int personCount, RandomValueGenerator generator) {
        this.randomValueGenerator = generator;
        calculatePoints(personCount);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    private void calculatePoints(int personCount) {
        points.add(generateRandomValue());
        while (personCount-- > 2) {
            if (!points.get(points.size() - 1)) {
                points.add(generateRandomValue());
                continue;
            }
            points.add(false);
        }
    }

    private boolean generateRandomValue() {
        return randomValueGenerator.generate();
    }
}
