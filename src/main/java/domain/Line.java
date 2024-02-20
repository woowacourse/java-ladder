package domain;

import utils.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Boolean> points = new ArrayList<>();

    public Line(int count, BooleanGenerator booleanGenerator) {
        for (int i = 0; i < count; i++) {
            points.add(booleanGenerator.generate());
        }
     }

     List<Boolean> getPoints() {
        return points;
     }
}
