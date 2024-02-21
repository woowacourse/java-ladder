package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Carpenter {

    private final List<Ladder> ladders;
    private final Energy energy;

    public Carpenter(Height height, NumberGenerator numberGenerator, int personCount) {
        ladders = new ArrayList<>(Collections.nCopies(height.getHeight() - 1, new Ladder(personCount)));
        this.energy = new Energy(numberGenerator);
    }

    public void buildLadders(int personCount) {
        for (Ladder ladder : ladders) {
            for (int i = 0; i < personCount - 1; i++) {
                if (ladder.hasStepDuplicated(i)) {
                    continue;
                }
                buildLadder(ladder, i);
            }
            System.out.println(ladder.getSteps());
        }
    }

    public void buildLadder(Ladder ladder, int currentStep) {
        if (energy.isEnergetic()) {
            ladder.buildSteps(currentStep);
        }
    }

    public List<Ladder> getLadders() {
        return ladders;
    }
}
