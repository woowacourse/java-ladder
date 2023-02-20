package domain;

import java.util.ArrayList;
import java.util.List;
import util.RandomValueGenerator;

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
        --personCount;
        for (int i = 0; i < personCount - 1; i++) {
            if (points.get(points.size() - 1) == false) {
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
