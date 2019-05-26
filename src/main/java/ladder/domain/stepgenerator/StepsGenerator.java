package ladder.domain.stepgenerator;

import ladder.domain.laddercomponent.Steps;

import java.util.List;

public interface StepsGenerator {
    Steps generateSteps();

    List<Steps> generateStepsList(int ladderHeight);
}
