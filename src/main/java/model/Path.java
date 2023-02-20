package model;

import exception.NotFoundPathException;
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
                .orElseThrow(NotFoundPathException::new);
    }

    public static Path calculatePath(Path otherPath, boolean passable){
        return Arrays.stream(Path.values())
                .filter(path -> path.isSamePassable(calculateMovable(otherPath, passable)))
                .findAny()
                .orElseThrow(NotFoundPathException::new);
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
