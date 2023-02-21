package laddergame.domain.ladder;

import laddergame.domain.rung.Line;
import laddergame.util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class LadderFactory {

    private static final int DEFAULT_COUNT = 1;

    private final BooleanGenerator rungBooleanGenerator;

    private LadderFactory(final BooleanGenerator rungBooleanGenerator) {
        this.rungBooleanGenerator = rungBooleanGenerator;
    }

    static LadderFactory create(final BooleanGenerator rungBooleanGenerator) {
        return new LadderFactory(rungBooleanGenerator);
    }

    public List<Line> makeLadder(final int heightNumber, final int participantCount) {
        List<Line> ladder = new ArrayList<>();
        for (int i = 0; i < heightNumber; i++) {
            ladder.add(Line.create(makeRungCount(participantCount), rungBooleanGenerator));
        }
        return ladder;
    }

    private int makeRungCount(final int participantCount) {
        return participantCount - DEFAULT_COUNT;
    }
}
