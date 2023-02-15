package laddergame.domain;

import laddergame.util.PointGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> points;

    public Line(int playerCount, PointGenerator pointGenerator) {
        final int pointCount = playerCount - 1;
        List<Boolean> tempPoints = new ArrayList<>();
        while (tempPoints.size() <= pointCount) {
            tempPoints.add(pointGenerator.generate());
        }
        this.points = List.copyOf(tempPoints);
    }
}
