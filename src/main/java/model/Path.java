package model;

import java.util.Arrays;

public enum Path {
    PASSABLE(true, "-----"),
    UN_PASSABLE(false, "     ");

    private final boolean movable;
    private final String log;

    Path(boolean movable, String log) {
        this.movable = movable;
        this.log = log;
    }

    public static Path calculatePath(boolean passable) {
        return Arrays.stream(Path.values())
            .filter(path -> path.isSameMovable(passable))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("유효한 Path를 찾지 못했습니다."));
    }

    public static Path calculatePath(Path otherPath, boolean passable){
        return Arrays.stream(Path.values())
            .filter(path -> path.isSameMovable(calculateMovable(otherPath, passable)))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("유효한 Path를 찾지 못했습니다."));
    }

    private boolean isSameMovable(boolean movable) {
        return this.movable == movable;
    }

    private static boolean calculateMovable(Path otherPath, boolean passable) {
        return !otherPath.movable && passable;
    }

    public String getLog() {
        return log;
    }
}
