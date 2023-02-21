package domain;

import domain.generator.BooleanGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final BooleanGenerator generator;
    List<LadderStep> ladderSteps = new ArrayList<>();

    public Line(int count, BooleanGenerator generator) {
        this.generator = generator;
        for (int index = 0; index < count; index++) {
            ladderSteps.add(getPoint(index));
        }
    }

    public List<LadderStep> getLadderSteps() {
        return Collections.unmodifiableList(ladderSteps);
    }

    private LadderStep getPoint(int index) {
        if (index > 0 && ladderSteps.get(index - 1).exists()) {
            return LadderStep.from(false);
        }
        return LadderStep.from(generator.generate());
    }

    public LadderStep getLadderStep(int index) {
        return ladderSteps.get(index);
    }
}
