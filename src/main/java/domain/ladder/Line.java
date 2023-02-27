package domain.ladder;

import domain.generator.LadderStepGenerator;
import domain.player.Position;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<LadderStep> line;

    public Line(int count, LadderStepGenerator ladderGenerator) {
        this.line = createLine(count, ladderGenerator);
    }

    private List<LadderStep> createLine(int count, LadderStepGenerator ladderGenerator) {
        List<LadderStep> newLine = new ArrayList<>();
        newLine.add(LadderStep.createFreely(ladderGenerator));
        for (int index = 1; index < count; index++) {
            LadderStep previousStep = newLine.get(index - 1);
            newLine.add(LadderStep.createConsideringPreviousStep(ladderGenerator, previousStep));
        }
        return newLine;
    }

    public List<LadderStep> getLadderSteps() {
        return Collections.unmodifiableList(line);
    }

    public boolean canMoveLeft(Position position) {
        return position.getValue() > 0 && leftStepExists(position);
    }

    public boolean canMoveRight(Position position) {
        return position.getValue() < line.size() && rightStepExists(position);
    }

    private boolean leftStepExists(Position position) {
        return isExists(position.getValue() - 1);
    }

    private boolean rightStepExists(Position position) {
        return isExists(position.getValue());
    }

    private boolean isExists(int index) {
        return line.get(index).exists();
    }
}
