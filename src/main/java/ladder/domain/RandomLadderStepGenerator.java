package ladder.domain;

import ladder.domain.generator.LadderStepGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLadderStepGenerator extends LadderStepGenerator {
    private final Random random = new Random();

    @Override
    protected List<Boolean> generate(final int participantCount) {
        List<Boolean> ladderStep = new ArrayList<>();
        Boolean isPrevExist = false;
        for (int currentCount = 0; currentCount < participantCount; currentCount++) {
            Boolean isCurrentExist = generatePath(isPrevExist);
            ladderStep.add(isCurrentExist);
            isPrevExist = isCurrentExist;
        }
        return ladderStep;
    }

    private Boolean generatePath(Boolean isPrevExist) {
        if (isPrevExist) {
            return false;
        }
        return random.nextBoolean();
    }
}
