package ladder.util;

import ladder.domain.Line;
import ladder.domain.Step;
import java.util.ArrayList;
import java.util.List;
import ladder.domain.strategy.linestrategy.LineStrategy;

public class CustomLineStrategy implements LineStrategy {
    private final List<Step> mockSteps;
    private int index = 0;

    public CustomLineStrategy(List<Step> mockSteps) {
        this.mockSteps = mockSteps;
    }

    @Override
    public Line generate(int width) {
        List<Step> steps = new ArrayList<>();
        for (int i = 0; i < width - 1; i++) {
            checkIndexLength();
            steps.add(mockSteps.get(index));
            index++;
        }
        return new Line(steps);
    }

    private void checkIndexLength() {
        if (index >= mockSteps.size()) {
            index = 0;
        }
    }
}
