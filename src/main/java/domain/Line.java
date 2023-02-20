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

    private final List<Boolean> points;

    public Line(int personCount) {
        this.points = createLine(personCount);
    }

    public List<Boolean> getPoints() {
        return points;
    }

    private List<Boolean> createLine(int personCount) {
        RandomValueGenerator randomValueGenerator = new RandomValueGenerator();
        List<Boolean> points = Collections.singletonList(new ArrayList<>().add(randomValueGenerator.getRandomValue()));
        while (personCount-- > 0) {
            if (!points.get(points.size() - 1)) points.add(randomValueGenerator.getRandomValue());
        }
        return points;
    }
}
