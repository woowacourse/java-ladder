package model;

import java.util.List;
import java.util.stream.IntStream;
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
        IntStream.range(0, paths.size() - 1)
                .forEach(i -> {
                    final Path left = paths.get(i);
                    final Path right = paths.get(i + 1);
                    if (left.isExist() && right.isExist()) {
                        throw new IllegalArgumentException("사다리의 경로는 연달아 있을 수 없습니다.");
                    }
                });
    }

    public List<Boolean> getExistFlags() {
        return paths.stream()
                .map(Path::isExist)
                .toList();
    }

    public boolean hasLeftPath(int column) {
        if (column <= 0) {
            return false;
        }
        Path leftPath = paths.get(column - 1);
        return leftPath.isExist();
    }

    public boolean hasRightPath(int column) {
        if (column >= paths.size()) {
            return false;
        }
        Path rightPath = paths.get(column);
        return rightPath.isExist();
    }

    public int size() {
        return paths.size();
    }
}
