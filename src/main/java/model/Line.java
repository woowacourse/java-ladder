package model;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> points = new ArrayList<>();
    private final PointGenerator pointGenerator;

    public Line(PointGenerator pointGenerator, int personCount) {
        this.pointGenerator = pointGenerator;
        createPoints(personCount);

    }

    public List<Boolean> getPoints() {
        return new ArrayList<>(points);
    }

    private void createPoints(int personCount) {
        int pointsCount = personCount - 1;
        for(int i=0; i<pointsCount; i++){
            points.add(pointGenerator.generate());
        }
    }
}
