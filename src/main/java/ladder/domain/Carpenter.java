package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.dto.BuiltLadderDto;
import ladder.domain.dto.ResultLadderDto;
import ladder.domain.randomGenerator.NumberGenerator;

public class Carpenter {

    private final List<Ladder> ladders;
    private final Energy energy;

    public Carpenter(Height height, int personCount, NumberGenerator numberGenerator) {
        ladders = makeLadder(height, personCount);
        this.energy = new Energy(numberGenerator);
    }

    public void buildLadders(int personCount) {
        ladders.forEach(ladder -> tryBuildLadder(personCount, ladder));
    }

    private List<Ladder> makeLadder(Height height, int personCount) {
        List<Ladder> ladders = new ArrayList<>();

        for (int currentHeight = 0; currentHeight < height.getHeight(); currentHeight++) {
            ladders.add(new Ladder(personCount));
            System.out.println(ladders);
        }
        return ladders;
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
        List<BuiltLadderDto> builtLadderDtos = ladders.stream()
                .map(Ladder::getSteps)
                .toList();

        return new ResultLadderDto(builtLadderDtos);
    }
}
