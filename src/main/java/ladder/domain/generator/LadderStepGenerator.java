package ladder.domain.generator;

import ladder.domain.LadderStep;
import ladder.domain.Path;
import ladder.exception.ContinuousPathException;
import ladder.exception.InvalidStepWidthException;

import java.util.List;

import static ladder.domain.Path.EMPTY;

public abstract class LadderStepGenerator {
    protected final int stepWidth;

    public LadderStepGenerator(final int stepWidth) {
        this.stepWidth = stepWidth;
    }

    public LadderStep generateValidStep() {
        List<Path> paths = generate();
        validateStepWidth(paths);
        validateContinuousPath(paths);
        return new LadderStep(paths);
    }

    private void validateStepWidth(final List<Path> paths) {
        if (paths.size() != stepWidth) {
            throw new InvalidStepWidthException();
        }
    }

    private void validateContinuousPath(final List<Path> paths) {
        paths.stream().reduce(EMPTY, (prevPath, currentPath) -> {
            if (prevPath.isExist() && currentPath.isExist()) {
                throw new ContinuousPathException();
            }
            return currentPath;
        });
    }

    protected abstract List<Path> generate();
}
