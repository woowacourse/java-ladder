package ladder.domain.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLadderStepGenerator extends LadderStepGenerator {
    private final Random random = new Random();

    public RandomLadderStepGenerator(int stepWidth) {
        super(stepWidth);
    }

    @Override
    protected List<Boolean> generate() {
        List<Boolean> ladderStep = new ArrayList<>();
        Boolean isPrevExist = false;
        for (int currentCount = 0; currentCount < stepWidth; currentCount++) {
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
