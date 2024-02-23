package ladder.domain.generator;

import ladder.domain.ladder.LadderStep;
import ladder.domain.ladder.Path;
import ladder.exception.generator.ContinuousPathException;
import ladder.exception.generator.InvalidStepWidthException;

import java.util.List;

import static ladder.domain.ladder.Path.EMPTY;

public abstract class LadderStepGenerator {
    protected final int stepWidth;

    protected LadderStepGenerator(final int stepWidth) {
        this.stepWidth = stepWidth;
    }

    public LadderStep generateValidStep() {
        final List<Path> paths = generate();
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
