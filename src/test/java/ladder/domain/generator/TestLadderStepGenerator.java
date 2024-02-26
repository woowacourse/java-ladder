package ladder.domain.generator;

import ladder.domain.ladder.LadderStep;

import java.util.List;

import static ladder.domain.ladder.Path.EMPTY;
import static ladder.domain.ladder.Path.EXIST;

public class TestLadderStepGenerator implements LadderStepGenerator {
    public LadderStep generate(final int stepWidth) {
        return new LadderStep(List.of(EXIST, EMPTY, EXIST));
    }
}
