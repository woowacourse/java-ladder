package model;

import java.util.List;
import model.path.Path;

public class Line {
    private static final int MIN_PERSON_COUNT = 2;

    private final List<Path> paths;

    public Line(final List<Path> paths) {
        final int personCount = paths.size() + 1;
        validatePersonCount(personCount);
        validateContinuousPaths(paths);
        this.paths = paths;
    }

    private void validatePersonCount(final int personCount) {
        if (personCount < MIN_PERSON_COUNT) {
            throw new IllegalArgumentException("참여할 사람은 최소 2명이어야 합니다.");
        }
    }

    private void validateContinuousPaths(final List<Path> paths) {
        int leftPathIndex = 0;
        int rightPathIndex = leftPathIndex + 1;
        while (rightPathIndex < paths.size()) {
            final Path left = paths.get(leftPathIndex);
            final Path right = paths.get(rightPathIndex);
            if (left.isExist() && right.isExist()) {
                throw new IllegalArgumentException("사다리의 경로는 연달아 있을 수 없습니다.");
            }
            leftPathIndex++;
            rightPathIndex++;
        }
    }

    public List<Boolean> getExistFlags() {
        return paths.stream()
                .map(Path::isExist)
                .toList();
    }

    private boolean hasLeftPath(final Position position) {
        checkPositionWithinLine(position);
        final int column = position.column();
        if (column == 0) {
            return false;
        }
        final Path leftPath = paths.get(column - 1);
        return leftPath.isExist();
    }

    private boolean hasRightPath(final Position position) {
        checkPositionWithinLine(position);
        final int column = position.column();
        if (column == paths.size()) {
            return false;
        }
        final Path rightPath = paths.get(column);
        return rightPath.isExist();
    }

    public int size() {
        return paths.size();
    }

    public Position getNextHorizontalPosition(Position position) {
        if (hasLeftPath(position)) {
            return position.getLeftPosition();
        }
        if (hasRightPath(position)) {
            return position.getRightPosition();
        }
        return position;
    }

    private void checkPositionWithinLine(final Position position) {
        final int column = position.column();
        final int maxPersonPosition = paths.size() + 1;
        if (column < 0 || column > maxPersonPosition) {
            throw new IllegalStateException("올바르지 않은 위치입니다.");
        }
    }
}
