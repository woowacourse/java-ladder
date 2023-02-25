package domain;

public enum PointSide {

    LEFT(-1),
    RIGHT(1),
    NONE(0);

    private final int movingPosition;

    PointSide(int movingPosition) {
        this.movingPosition = movingPosition;
    }

    public int getMovingPosition() {
        return this.movingPosition;
    }

}
