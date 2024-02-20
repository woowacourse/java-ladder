package ladder.domain.generator;

import java.util.List;

public abstract class LadderStepGenerator {
    protected final int stepWidth;

    public LadderStepGenerator(final int stepWidth) {
        this.stepWidth = stepWidth;
    }

    public List<Boolean> generateValidStep() {
        List<Boolean> path = generate();
        validateStepWidth(path);
        validateContinuousPath(path);
        return path;
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
