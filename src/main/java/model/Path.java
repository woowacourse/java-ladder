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
                .filter(path -> path.isSamePassable(calculateMovable(otherPath, passable)))
                .findAny()
                .orElseThrow(() -> new IllegalStateException("유효한 Path를 찾지 못했습니다."));
    }

    private boolean isSamePassable(boolean passable) {
        return this.passable == passable;
    }

    private static boolean calculateMovable(Path otherPath, boolean passable) {
        return !otherPath.passable && passable;
    }

    public boolean isPassable() {
        return passable;
    }
}
