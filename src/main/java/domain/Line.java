package domain;

import java.util.ArrayList;
import java.util.List;

import domain.numbergenerator.NumberGenerator;

public class Line {

    private static final int GENERATE_NUMBER = 1;

    private final List<Boolean> points = new ArrayList<>();

    public Line(int personCount, NumberGenerator numberGenerator) {
        generatePoints(personCount, numberGenerator);
    }

    private void generatePoints(int personCount, NumberGenerator numberGenerator) {
        for (int i = 0; i < personCount - 1; i++) {
            generatePoint(numberGenerator);
        }
    }

    private void generatePoint(NumberGenerator numberGenerator) {
        if (isGenerated(numberGenerator) && !hasAdjacentPoint()) {
            points.add(true);
            return;
        }
        points.add(false);
    }

    private static boolean isGenerated(NumberGenerator numberGenerator) {
        return numberGenerator.generate() == GENERATE_NUMBER;
    }

    private boolean hasAdjacentPoint() {
        return !points.isEmpty() && points.get(points.size() - 1);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
