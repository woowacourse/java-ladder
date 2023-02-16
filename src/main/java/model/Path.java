package model;

import exception.NotFoundPathException;
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
            .orElseThrow(NotFoundPathException::new);
    }

    public static Path calculatePath(Path otherPath, boolean passable){
        return Arrays.stream(Path.values())
            .filter(path -> path.isSameMovable(calculateMovable(otherPath, passable)))
            .findAny()
            .orElseThrow(NotFoundPathException::new);
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
