package ladder.domain;

import java.util.List;

public interface StepsGenerator {
    Steps generateSteps();
    List<Steps> generateStepsList(int ladderHeight);
}
