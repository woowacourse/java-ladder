package ladder.model;

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
