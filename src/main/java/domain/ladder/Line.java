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
        final List<LadderStep> line = new ArrayList<>();
        line.add(LadderStep.from(ladderGenerator.generate()));
        for (int index = 1; index < count; index++) {
            LadderStep previousStep = line.get(index - 1);
            LadderStep ladderStep = LadderStep.of(previousStep, ladderGenerator);
            line.add(ladderStep);
        }
        return line;
    }

    public List<LadderStep> getLadderSteps() {
        return Collections.unmodifiableList(line);
    }

    public int getNextStepIndex(int index) {
        if (canGoLeft(index) && line.get(index - 1).exists()) {
            return Movement.GO_LEFT.move(index);
        }
        if (canGoRight(index) && line.get(index).exists()) {
            return Movement.GO_RIGHT.move(index);
        }
        return Movement.STAY.move(index);
    }

    private boolean canGoRight(int index) {
        return index < line.size();
    }

    private boolean canGoLeft(int index) {
        return index > 0;
    }

}
