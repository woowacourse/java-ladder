package domain.ladder;

import domain.generator.BooleanGenerator;
import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<LadderStep> line;

    public Line(int count, BooleanGenerator ladderGenerator) {
        this.line = createLine(count, ladderGenerator);
    }

    private List<LadderStep> createLine(int count, BooleanGenerator ladderGenerator) {
        final List<LadderStep> ladderSteps;
        ladderSteps = new ArrayList<>();
        for (int index = 0; index < count; index++) {
            if (index > 0 && isLadderStepExists(index - 1)) {
                ladderSteps.add(LadderStep.from(false));
            } else {
                ladderSteps.add(LadderStep.from(ladderGenerator.generate()));
            }
        }
        return ladderSteps;
    }

/*    public List<LadderStep> getLadderSteps() {
        return Collections.unmodifiableList(ladderSteps);
    }*/

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
        return line.get(index).exists();
    }

    private boolean canGoRight(int index) {
        return index < line.size();
    }

    private boolean canGoLeft(int index) {
        return index > 0;
    }

}
