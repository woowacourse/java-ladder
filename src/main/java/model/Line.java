package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points = new ArrayList<>();

    public Line(PointGenerator pointGenerator, int personCount) {
        createPoints(pointGenerator, personCount);
    }

    public List<Boolean> getPoints() {
        return new ArrayList<>(points);
    }

    private void createPoints(PointGenerator pointGenerator, int personCount) {
        points.add(pointGenerator.generate());
        for (int index = 0; index < calculatePointsCount(personCount) - 1; index++) {
            points.add(makePointAvoidingTrueRepetition(pointGenerator, index));
        }
    }

    private int calculatePointsCount(int personCount) {
        return personCount - 1;
    }

    private Boolean makePointAvoidingTrueRepetition(PointGenerator pointGenerator, int index) {
        if (points.get(index).equals(true)) {
            return Boolean.FALSE;
        }
        return pointGenerator.generate();
    }
}
