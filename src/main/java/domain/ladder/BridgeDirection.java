package domain.ladder;

public enum BridgeDirection {
    LEFT(-1),
    RIGHT(1),
    NONE(0);

    private final int value;

    BridgeDirection(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
