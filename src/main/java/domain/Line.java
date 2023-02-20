package domain;

import util.RandomValueGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 베베
 * @version 1.0.0
 * @Created by 베베 on 2023. 02. 18.
 */
public class Line {

    private final List<Boolean> points = new ArrayList<>();

    public Line(int personCount) {
        calculatePoints(personCount);
    }

    public List<Boolean> getPoints() {
        return points;
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
        System.out.println("points = " + points);
    }
}
