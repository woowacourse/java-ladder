package domain.ladder;

import domain.generator.BooleanGenerator;
import domain.player.Position;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<LadderStep> line;

    public Line(int count, BooleanGenerator ladderGenerator) {
        this.line = createLine(count, ladderGenerator);
    }

    private List<LadderStep> createLine(int count, BooleanGenerator ladderGenerator) {
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
        return position.getValue() > 0;
    }

    public boolean canMoveRight(Position position) {
        return position.getValue() < line.size();
    }

    public boolean isExists(int index) {
        return line.get(index).exists();
    }
}
