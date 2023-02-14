package domain;

import utils.NumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private static final int MIN_NUMBER_RETURN_TRUE = 4;

    private final List<Boolean> points;

    private Line(List<Boolean> points) {
        this.points = points;
    }

    public static Line create(int height, NumberGenerator numberGenerator) {
        List<Boolean> points = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            points.add(isPoint(numberGenerator.generate()));
        }
        return new Line(points);
    }

    private static Boolean isPoint(int number) {
        return number >= MIN_NUMBER_RETURN_TRUE;
    }

    public int getPointSize() {
        return this.points.size();
    }

    public List<Boolean> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
