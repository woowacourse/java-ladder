package ladder.testutil;

import ladder.domain.generator.LadderStepsGenerator;
import ladder.domain.generator.PathAvailabilityGenerator;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.size.LadderSize;

import java.util.List;

public class LadderGenerator {
    public static Ladder generate(final List<Boolean> pathAvailabilities, final int width, final int height) {
        final LadderSize ladderSize = new LadderSize(width, height);
        final PathAvailabilityGenerator pathAvailabilityGenerator = new TestPathAvailabilityGenerator(pathAvailabilities);
        final LadderStepsGenerator ladderStepsGenerator = new LadderStepsGenerator(pathAvailabilityGenerator);
        return new Ladder(ladderSize, ladderStepsGenerator);
    }
}
