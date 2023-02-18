package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StepPoints {

    private final List<Boolean> stepPoints = new ArrayList<>();
    private final RandomGenerator randomGenerator;

    public StepPoints(RandomGenerator randomPointGenerator, int count) {
        randomGenerator = randomPointGenerator;
        initialize(count);
    }

    private void initialize(int count) {
        boolean previousValue = false;

        for (int i = 0; i < count; i++) {
            boolean generatedPoint = randomGenerator.generate(previousValue);
            stepPoints.add(generatedPoint);
            previousValue = generatedPoint;
        }
    }

    public List<Boolean> toUnmodifiableStepPoints() {
        return Collections.unmodifiableList(stepPoints);
    }
}
