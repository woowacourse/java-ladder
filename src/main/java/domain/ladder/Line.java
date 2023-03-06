package domain.ladder;

import domain.player.Position;
import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private final List<Step> steps;

    public Line(final List<Step> steps) {
        validateSteps(steps);
        this.steps = steps;
    }

    private void validateSteps(final List<Step> steps) {
        validateContinuous(steps);
        validateConnections(steps);
    }

    private void validateConnections(final List<Step> steps) {
        steps.stream().reduce((previousStep, currentStep)->{
            if(previousStep == Step.RIGHT && currentStep != Step.LEFT){
                throwWrongShapeLineException();
            }
            return currentStep;
        });
    }

    private void validateContinuous(final List<Step> steps) {
        steps.stream().reduce((previousStep, currentStep) -> {
            if (previousStep == currentStep && previousStep != Step.NONE) {
                throwWrongShapeLineException();
            }

            return currentStep;
        });
    }

    private void throwWrongShapeLineException() {
        throw new IllegalArgumentException("잘못된 사다리 모양입니다.");
    }

    public int getWidth() {
        if (this.steps.isEmpty()) {
            return 0;
        }

        return this.steps.size();
    }

    public List<Boolean> getRightConnectionCondition() {
        return List.copyOf(steps.stream()
                .map(Step::isRightConnection)
                .collect(Collectors.toList()));
    }

    public Position ride(final Position position) {
        Step step = steps.get(position.getPosition());
        return step.step(position);
    }
}
