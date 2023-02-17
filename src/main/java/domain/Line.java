package domain;

import java.util.ArrayList;
import java.util.List;

import domain.numbergenerator.BooleanGenerator;

public class Line {

    private final List<Point> points = new ArrayList<>();

    public Line(int personCount, BooleanGenerator numberGenerator) {
        generatePoints(personCount, numberGenerator);
    }

    private boolean isGenerated(BooleanGenerator numberGenerator) {
        return numberGenerator.generate();
    }

    private void generatePoints(int personCount, BooleanGenerator booleanGenerator) {
        for (int i = 0; i < personCount - 1; i++) {
            generatePoint(booleanGenerator);
        }
    }

    private void generatePoint(BooleanGenerator booleanGenerator) {
        if (isGenerated(booleanGenerator) && !hasAdjacentPoint()) {
            points.add(Point.CONNECTION);
            return;
        }
        points.add(Point.SEPARATION);
    }

    private boolean hasAdjacentPoint() {
        return !points.isEmpty() && points.get(points.size() - 1).isConnection();
    }

    public List<Point> getPoints() {
        return points;
    }
}
