package ladder.domain.laddercomponent;

import java.util.List;

public class Steps {
    private final List<Step> steps;

    public Steps(List<Step> steps) {
        this.steps = steps;
    }

    public List<Step> getSteps() {
        return steps;
    }
}
