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

    private LadderStep getLadderStep(int index) {
        return ladderSteps.get(index);
    }

    public int getNextStep(int index) {
        if (index == 0) {
            if (isExists(index)) {
                return Movement.GO_RIGHT.move(index);
            }
        }
        if (index == ladderSteps.size()) {
            if (isExists(index - 1)) {
                return Movement.GO_LEFT.move(index);
            }
        }
        if (isExists(index)) {
            return Movement.GO_RIGHT.move(index);
        }
        if (isExists(index - 1)) {
            return Movement.GO_LEFT.move(index);
        }
        return Movement.STAY.move(index);
    }

    private boolean isExists(int entranceIndex) {
        return getLadderStep(entranceIndex).exists();
    }
}
