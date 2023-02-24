package domain.ladder;

import domain.generator.BooleanGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final BooleanGenerator ladderGenerator;
    private List<LadderStep> ladderSteps = new ArrayList<>();

    public Line(int count, BooleanGenerator ladderGenerator) {
        this.ladderGenerator = ladderGenerator;
        for (int index = 0; index < count; index++) {
            ladderSteps.add(findLadderStepBy(index));
        }
    }

    public List<LadderStep> getLadderSteps() {
        return Collections.unmodifiableList(ladderSteps);
    }

    private LadderStep findLadderStepBy(int index) {
        // TODO: 예외 상황을 처리해 주자
        if (index > 0 && isLadderStepExists(index - 1)) {
            return LadderStep.from(false);
        }
        return LadderStep.from(ladderGenerator.generate());
    }

    public int getNextStepIndex(int index) {
        if (canGoLeft(index) && isLadderStepExists(index - 1)) {
            return Movement.GO_LEFT.move(index);
        }
        if (canGoRight(index) && isLadderStepExists(index)) {
            return Movement.GO_RIGHT.move(index);
        }
        return Movement.STAY.move(index);
    }

    private boolean isLadderStepExists(int index) {
        return ladderSteps.get(index).exists();
    }

    private boolean canGoRight(int index) {
        return index < ladderSteps.size();
    }

    private boolean canGoLeft(int index) {
        return index > 0;
    }

}
