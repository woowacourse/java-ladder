package model;

import java.util.List;

public enum Direction {

    LEFT(-1),
    RIGHT(1),
    NONE(0);

    private final int offset;

    Direction(int offset) {
        this.offset = offset;
    }

    public static Direction findDirection(int position, List<Path> paths) {
        if (isLeftMovable(position, paths)) {
            return LEFT;
        }
        if (isRightMovable(position, paths)) {
            return RIGHT;
        }
        return NONE;
    }

    private static boolean isLeftMovable(int position, List<Path> paths) {
        return position - 1 >= 0 && paths.get(position - 1).isPassable();
    }

    private static boolean isRightMovable(int position, List<Path> paths) {
        return position < (paths.size()) && paths.get(position).isPassable();
    }

    public int move(int position) {
        return position + this.offset;
    }
}
