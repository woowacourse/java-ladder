package ladder.domain.generator;

import ladder.domain.LadderStep;

import java.util.List;

public abstract class LadderStepGenerator {
    protected final int stepWidth;

    public LadderStepGenerator(final int stepWidth) {
        this.stepWidth = stepWidth;
    }

    public LadderStep generateValidStep() {
        List<Boolean> path = generate();
        validateStepWidth(path);
        validateContinuousPath(path);
        // Boolean -> Availability
        return new LadderStep(path);
    }

    private void validateStepWidth(final List<Boolean> path) {
        if (path.size() != stepWidth) {
            throw new RuntimeException();
        }
    }

    private void validateContinuousPath(final List<Boolean> path) {
        path.stream().reduce(false, (isPrevExist, isCurrentExist) -> {
            if (isPrevExist && isCurrentExist) {
                throw new RuntimeException();
            }
            return isCurrentExist;
        });
    }

    protected abstract List<Boolean> generate();
}
