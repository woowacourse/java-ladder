package model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Line {

    private final List<Path> paths;

    public Line(List<Path> paths) {
        validatePaths(paths);

        this.paths = paths;
    }

    private void validatePaths(List<Path> paths) {
        if (Objects.isNull(paths)) {
            throw new IllegalStateException("사다리 경로가 정상적으로 입력되지 않았습니다.");
        }
        if (paths.isEmpty()) {
            throw new IllegalArgumentException("1 이상의 경로를 입력해주세요.");
        }
        if (isMultiplePassable(paths)) {
            throw new IllegalArgumentException("사다리는 연속적으로 건널 수 없습니다.");
        }
    }

    private boolean isMultiplePassable(List<Path> paths) {
        return IntStream.range(0, paths.size() - 1)
                .anyMatch(i -> isMultiplePassable(paths.get(i), paths.get(i + 1)));
    }

    private boolean isMultiplePassable(Path leftPath, Path rightPath) {
        return leftPath.isMultiplePassable(rightPath);
    }

    public boolean isSamePathSize(Line otherLine) {
        return this.paths.size() == otherLine.paths.size();
    }

    public List<Path> getLine() {
        return Collections.unmodifiableList(paths);
    }
}
