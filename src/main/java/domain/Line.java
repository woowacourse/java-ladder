package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<StepPoint> stepPoints;

    public Line(int numberOfCell, StepGenerator stepGenerator) {
        stepPoints = new ArrayList<>();
        stepPoints.add(stepGenerator.generate());
        for (int cellIndex = 1; cellIndex < numberOfCell; cellIndex++) {
            stepPoints.add(makeOnePoint(cellIndex, stepGenerator));
        }
    }

    private StepPoint makeOnePoint(int cellIndex, StepGenerator stepGenerator) {
        if (isPreviousStepExist(cellIndex)) {
            return StepPoint.ABSENT;
        }
        return stepGenerator.generate();
    }

    private boolean isPreviousStepExist(int cellIndex) {
        return isStepExistAt(cellIndex - 1);
    }

    public boolean isStepExistAt(int cellIndex) {
        return stepPoints.get(cellIndex).isExist();
    }

    public List<StepPoint> getStepPoints() {
        return stepPoints;
    }

    public void findNextLocation(Player player) {
        if (canMoveToLeft(player.getPosition())) {
            player.moveLeft();
            return;
        }
        if (canMoveToRight(player.getPosition())) {
            player.moveRight();
        }
    }

    private boolean canMoveToLeft(Position position) {
        return position.getPosition() > 0 && stepPoints.get(position.getPosition() - 1) == StepPoint.PRESENT;
    }

    private boolean canMoveToRight(Position position) {
        return position.getPosition() < stepPoints.size() && stepPoints.get(position.getPosition()) == StepPoint.PRESENT;
    }
}
