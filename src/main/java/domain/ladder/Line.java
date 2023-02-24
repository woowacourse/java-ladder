package domain.ladder;

import domain.generator.BooleanGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<LadderStep> line;

    public Line(int count, BooleanGenerator ladderGenerator) {
        this.line = createLine(count, ladderGenerator);
    }

    private List<LadderStep> createLine(int count, BooleanGenerator ladderGenerator) {
        List<LadderStep> line = new ArrayList<>();
        for (int index = 0; index < count; index++) {
            line.add(generateLadderStep(ladderGenerator, index));
        }
        return line;
    }

    private LadderStep generateLadderStep(BooleanGenerator ladderGenerator, int index) {
        if (isFirstLadderStep(index)) {
            return generateFreely(ladderGenerator);
        }
        return generateConsideringPreviousCondition(ladderGenerator, index);
    }

    private static boolean isFirstLadderStep(int index) {
        return index == 0;
    }

    private LadderStep generateFreely(BooleanGenerator ladderGenerator) {
        return LadderStep.of(ladderGenerator);
    }

    private LadderStep generateConsideringPreviousCondition(BooleanGenerator ladderGenerator, int index) {
        LadderStep previousStep = line.get(index - 1);
        return LadderStep.of(ladderGenerator, previousStep);
    }


    public List<LadderStep> getLadderSteps() {
        return Collections.unmodifiableList(line);
    }

    public int getNextStepIndex(int index) {
        if (canGoLeft(index) && isExists(index - 1)) {
            return Movement.GO_LEFT.move(index);
        }
        if (canGoRight(index) && isExists(index)) {
            return Movement.GO_RIGHT.move(index);
        }
        return Movement.STAY.move(index);
    }

    private boolean canGoLeft(int index) {
        return index > 0;
    }

    private boolean canGoRight(int index) {
        return index < line.size();
    }

    private boolean isExists(int index) {
        return line.get(index).exists();
    }
}
