package domain;

import java.util.ArrayList;
import java.util.List;

import domain.numbergenerator.NumberGenerator;

public class Line {

    private List<Boolean> points;

    public Line(int personCount, NumberGenerator numberGenerator) {
        points = new ArrayList<>();
        generatePoints(personCount, numberGenerator);
    }

    private void generatePoints(int personCount, NumberGenerator numberGenerator) {
        for (int i = 0; i < personCount - 1; i++) {
            generatePoint(numberGenerator);
        }
    }

    private void generatePoint(NumberGenerator numberGenerator) {
        if (numberGenerator.generate() == 1 && !hasAdjacentPoint()) {
            points.add(true);
            return;
        }
        points.add(false);
    }

    private boolean hasAdjacentPoint() {
        return !points.isEmpty() && points.get(points.size() - 1);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
