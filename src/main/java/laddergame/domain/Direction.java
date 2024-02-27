package laddergame.domain;

public enum Direction {
    // TODO: NONE으로 바꾸기
    LEFT(-1), RIGHT(1), DOWN(0);

    private final int movement;

    Direction(final int movement) {
        this.movement = movement;
    }

    public int getMovement() {
        return movement;
    }
}
