package domain;

import util.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final int FIRST_POSITION_OF_STEP = 0;

    private final List<LineStep> line;
    private final BooleanGenerator booleanGenerator;

    private Line(List<LineStep> line, BooleanGenerator booleanGenerator) {
        this.line = line;
        this.booleanGenerator = booleanGenerator;
    }

    public static Line makeDefaultLine(int numberOfHorizontalSteps, BooleanGenerator booleanGenerator) {
        List<LineStep> line = new ArrayList<>();
        for (int horizontalStep = 0; horizontalStep < numberOfHorizontalSteps; horizontalStep++) {
            line.add(LineStep.NON_EXIST);
        }
        return new Line(line, booleanGenerator);
    }

    public void generateRandomLine() {
        makeFirstRandomStep();
        for (int stepIndex = 1; stepIndex < line.size(); stepIndex++) {
            makeNextRandomSteps(stepIndex);
        }
    }

    private void makeFirstRandomStep() {
        if (booleanGenerator.generate()) {
            line.set(0, LineStep.findBy(true));
        }
    }

    private void makeNextRandomSteps(int stepIndex) {
        boolean randomBoolean = booleanGenerator.generate();
        if (!isExistPrevStep(stepIndex) && randomBoolean) {
            line.set(stepIndex, LineStep.findBy(true));
            return;
        }
        if (isExistPrevStep(stepIndex) || !randomBoolean) {
            line.set(stepIndex, LineStep.findBy(false));
        }
    }

    private boolean isExistPrevStep(int stepIndex) {
        return this.line.get(stepIndex - 1).equals(LineStep.EXIST);
    }

    public void movePlayerInLine(Player player) {
        int leftStepPositionOfPlayer = player.getPosition() - 1;
        int rightStepPositionOfPlayer = player.getPosition();

        movePlayerToLeft(player, leftStepPositionOfPlayer);
        movePlayerToRight(player, rightStepPositionOfPlayer);
    }

    private void movePlayerToLeft(Player player, int leftStepPositionOfPlayer) {
        if (leftStepPositionOfPlayer >= FIRST_POSITION_OF_STEP
                && line.get(leftStepPositionOfPlayer).equals(LineStep.EXIST)) {
            player.moveToLeft();
        }
    }

    private void movePlayerToRight(Player player, int rightStepPositionOfPlayer) {
        if (rightStepPositionOfPlayer < this.line.size()
                && line.get(rightStepPositionOfPlayer).equals(LineStep.EXIST)) {
            player.moveToRight();
        }
    }

    public List<LineStep> getLine() {
        return this.line;
    }
}
