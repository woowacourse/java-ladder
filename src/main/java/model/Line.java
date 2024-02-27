package model;

import java.util.List;
import java.util.Objects;
import model.path.Path;

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

    public int move(int currentIndex) {
        currentIndex = moveRight(currentIndex);
        currentIndex = moveLeft(currentIndex);
        return currentIndex;
    }
    
    private int moveRight(int currentIndex) {
        Path right = paths.get(currentIndex);
        if (right.isExist()) {
            currentIndex++;
        }
        return currentIndex;
    }
    
    private int moveLeft(int currentIndex) {
        int leftIndex = currentIndex - 1;
        Path left = paths.get(leftIndex);
        if (canMove(leftIndex) && left.isExist()) {
            currentIndex--;
        }
        return currentIndex;
    }

    // TODO: 기똥찬 이름 고민
    private boolean canMove(final int leftIndex) {
        return leftIndex > 0;
    }
}
