package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import strategy.PassGenerator;

public class Line {

    private static final int MINIMUM_PATH_SIZE = 2;

    private final List<Path> paths;

    private Line(List<Path> paths) {
        validatePaths(paths);

        this.paths = new ArrayList<>(paths);
    }

    private void validatePaths(List<Path> paths) {
        if (paths.isEmpty()) {
            throw new IllegalArgumentException("1 이상의 경로를 입력해주세요.");
        }
        if (isMultiplePassable(paths)) {
            throw new IllegalArgumentException("사다리는 연속적으로 건널 수 없습니다.");
        }
    }

    public static Line of(int totalParticipantSize, PassGenerator generator) {
        List<Path> paths = new ArrayList<>();

        while (--totalParticipantSize > 0) {
            Path path = generatePath(paths, generator);
            paths.add(path);
        }
        return new Line(paths);
    }

    private static Path generatePath(List<Path> paths, PassGenerator generator) {
        int size = paths.size();

        if (size > 0) {
            return Path.calculatePath(paths.get(size - 1), generator.generate());
        }
        return Path.calculatePath(generator.generate());
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

    public Direction findDirection(int position) {
        if (isLeftPassable(position)) {
            return Direction.LEFT;
        }
        if (isRightPassable(position)) {
            return Direction.RIGHT;
        }
        return Direction.NONE;
    }

    private boolean isLeftPassable(int position) {
        return position - 1 >= 0 && paths.get(position - 1).isPassable();
    }

    private boolean isRightPassable(int position) {
        return position < (paths.size()) && paths.get(position).isPassable();
    }

    public List<Path> getLine() {
        return List.copyOf(paths);
    }
}
