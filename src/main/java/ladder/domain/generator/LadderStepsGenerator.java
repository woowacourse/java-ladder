package ladder.domain.generator;

import ladder.domain.ladder.LadderStep;

import java.util.List;

public interface LadderStepsGenerator {
    List<LadderStep> generate();
}
