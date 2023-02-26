package model;

import java.util.Arrays;

public enum Path {
    PASSABLE(true),
    UN_PASSABLE(false);

    private final boolean passable;

    Path(boolean passable) {
        this.passable = passable;
    }

    public static Path calculatePath(boolean passable) {
        return Arrays.stream(Path.values())
                .filter(path -> path.isSamePassable(passable))
                .findAny()
                .orElseThrow(() -> new IllegalStateException("유효한 Path를 찾지 못했습니다."));
    }

    public static Path calculatePath(Path otherPath, boolean passable){
        return Arrays.stream(Path.values())
                .filter(path -> path.isSamePassable(calculatePassable(otherPath, passable)))
                .findAny()
                .orElseThrow(() -> new IllegalStateException("유효한 Path를 찾지 못했습니다."));
    }

    private static boolean calculatePassable(Path otherPath, boolean passable) {
        return !otherPath.passable && passable;
    }

    private boolean isSamePassable(boolean passable) {
        return this.passable == passable;
    }

    public boolean isMultiplePassable(Path otherPath) {
        return this.passable && otherPath.passable;
    }

    public boolean isPassable() {
        return passable;
    }
}
