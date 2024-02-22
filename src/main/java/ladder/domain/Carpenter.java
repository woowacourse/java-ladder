package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.dto.BuiltLadderDto;
import ladder.domain.dto.ResultLadderDto;
import ladder.domain.randomGenerator.NumberGenerator;

public class Carpenter {

    private static final int LOOP_START_INDEX = 0;
    private final List<Ladder> ladders;
    private final Energy energy;

    public Carpenter(Height height, int personCount, NumberGenerator numberGenerator) {
        ladders = makeLadder(height, personCount);
        this.energy = new Energy(numberGenerator);
    }

    private List<Ladder> makeLadder(Height height, int personCount) {
        List<Ladder> ladders = new ArrayList<>();

        for (int currentHeight = LOOP_START_INDEX; currentHeight < height.getHeight(); currentHeight++) {
            ladders.add(new Ladder(personCount));
        }
        return ladders;
    }

    public void buildLadders(int personCount) {
        ladders.forEach(ladder -> tryBuildLadder(personCount, ladder));
    }

    private void tryBuildLadder(int personCount, Ladder ladder) {
        int workableStepCount = personCount - 1;

        for (int currentPosition = LOOP_START_INDEX; currentPosition < workableStepCount; currentPosition++) {
            tryBuildLadderStep(ladder, currentPosition);
        }
    }

    private void tryBuildLadderStep(Ladder ladder, int currentPosition) {
        if (!ladder.hasStepDuplicated(currentPosition)) {
            buildLadderStep(ladder, currentPosition);
        }
    }

    private void buildLadderStep(Ladder ladder, int currentPosition) {
        if (energy.isEnergetic()) {
            ladder.buildSteps(currentPosition);
        }
    }

    public ResultLadderDto getResultLadders() {
        List<BuiltLadderDto> builtLadderDtos = ladders.stream()
                .map(Ladder::getSteps)
                .toList();

        return new ResultLadderDto(builtLadderDtos);
    }
}
