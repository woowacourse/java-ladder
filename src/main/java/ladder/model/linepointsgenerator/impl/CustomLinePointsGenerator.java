package ladder.model.linepointsgenerator.impl;

import ladder.model.ladder.Points;
import ladder.model.linepointsgenerator.LinePointsGenerator;

import java.util.List;

public class CustomLinePointsGenerator implements LinePointsGenerator {
    private List<Boolean> customLinePoints;

    public CustomLinePointsGenerator(List<Boolean> customLinePoints) {
        this.customLinePoints = customLinePoints;
    }

    @Override
    public Points generatePoints() {
        return new Points(customLinePoints);
    }
}
