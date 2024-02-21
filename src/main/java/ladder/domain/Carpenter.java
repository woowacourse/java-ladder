package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ladder.domain.dto.ResultLadderDto;

public class Carpenter {

    private final List<Ladder> ladders;
    private final Energy energy;

    public Carpenter(Height height, int personCount, NumberGenerator numberGenerator) {
        ladders = new ArrayList<>(Collections.nCopies(height.getHeight() - 1, new Ladder(personCount)));
        this.energy = new Energy(numberGenerator);
    }

    public void buildLadders(int personCount) {
        ladders.forEach(ladder -> tryBuildLadder(personCount, ladder));
    }

    private void tryBuildLadder(int personCount, Ladder ladder) {
        int workableSteps = personCount - 1;
        for (int currentPosition = 0; currentPosition < workableSteps; currentPosition++) {
            tryBuildLadderStep(ladder, currentPosition);
        }
    }

    private void tryBuildLadderStep(Ladder ladder, int currentPosition) {
        if (!ladder.hasStepDuplicated(currentPosition)) {
            buildLadderStep(ladder, currentPosition);
        }
    }

    private void buildLadderStep(Ladder ladder, int currentStep) {
        if (energy.isEnergetic()) {
            ladder.buildSteps(currentStep);
        }
    }

    public ResultLadderDto getResultLadders() {
        return new ResultLadderDto(Collections.unmodifiableList(ladders));
    }
}
