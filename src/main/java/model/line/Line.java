package model.line;

import java.util.List;
import model.Index;

public class Line {
    private static final int MIN_PATH_SIZE = 1;

    private final List<Path> paths;

    public Line(final List<Path> paths) {
        validatePathCount(paths.size());
        checkContinuousPaths(paths);
        this.paths = paths;
    }

    private void validatePathCount(final int pathSize) {
        if (pathSize < MIN_PATH_SIZE) {
            throw new IllegalArgumentException("사다리의 경로는 비어있더라도 최소 1개 이상이여야 합니다.");
        }
    }

    private void checkContinuousPaths(final List<Path> paths) {
        for (int i = 0; i < paths.size() - 1; i++) {
            final Path left = paths.get(i);
            final Path right = paths.get(i + 1);
            validateContinuousPaths(left, right);
        }
    }

    private void validateContinuousPaths(final Path left, final Path right) {
        if (left == Path.EXIST && right == Path.EXIST) {
            throw new IllegalArgumentException("사다리의 경로는 연달아 있을 수 없습니다.");
        }
    }

    public List<Boolean> getExistFlags() {
        return paths.stream()
                .map(Path::isExist)
                .toList();
    }

    public Index move(final Index currentIndex) {
        if (canMoveRight(currentIndex)) {
            return currentIndex.getNext();
        }

        if (canMoveLeft(currentIndex)) {
            return currentIndex.getPast();
        }
        return currentIndex;
    }

    private boolean canMoveRight(final Index currentIndex) {
        if (currentIndex.isLower(paths.size())) {
            Path right = paths.get(currentIndex.getIndex());
            return right.isExist();
        }
        return false;
    }

    private boolean canMoveLeft(final Index currentIndex) {
        if (!currentIndex.isStartIndex()) {
            Index leftIndex = currentIndex.getPast();
            Path left = paths.get(leftIndex.getIndex());
            return left.isExist();
        }
        return false;
    }

    public int getPathsSize() {
        return paths.size();
    }
}
