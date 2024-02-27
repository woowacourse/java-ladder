package laddergame.domain;

public enum Direction {
    DOWN(0, 1),
    RIGHT(1, 1),
    LEFT(-1, 1),
    END(0, 0);

    private final int moveX;
    private final int moveY;

    Direction(int moveX, int moveY) {
        this.moveX = moveX;
        this.moveY = moveY;
    }

    public int getMoveX() {
        return moveX;
    }

    public int getMoveY() {
        return moveY;
    }
}
