package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Boolean> steps;

    public Ladder(int personCount) {
        this.steps = new ArrayList<>(Collections.nCopies(personCount - 1, false));
    }

    public List<Boolean> getSteps() {
        return steps;
    }

    public void buildSteps(int currentPosition) {
        steps.set(currentPosition, true);
    }

    public boolean hasStepDuplicated(int currentPosition) {
        boolean bool = false;

        if (currentPosition > 0) {
            bool = steps.get(currentPosition - 1);
        }

        return bool;
    }
}
