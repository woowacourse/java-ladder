package ladder.domain;

import java.util.List;

public abstract class LadderPathGenerator {
    public List<Boolean> generateValidPath(final int participantCount) {
        List<Boolean> path = generate(participantCount);
        validatePathWidth(path, participantCount);
        validateContinuousPath(path);
        return path;
    }

    private void validatePathWidth(final List<Boolean> path, final int participantCount) {
        if (path.size() != participantCount) {
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

    protected abstract List<Boolean> generate(final int participantCount);
}
