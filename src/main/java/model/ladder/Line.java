package model.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Step> steps;

    private Line(List<Step> steps) {
        this.steps = steps;
    }

    public static Line from(final Width width) {
        List<Step> steps = new ArrayList<>();
        Step previous = Step.from(StepStatus.EMPTY);
        while (steps.size() < width.size()) {
            Step step = Step.of(previous, new RandomStatusGenerator());
            steps.add(step);
            previous = step;
        }
        return new Line(steps);
    }

    public int size() {
        return steps.size();
    }
}
