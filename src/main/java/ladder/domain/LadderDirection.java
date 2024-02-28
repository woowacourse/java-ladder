package ladder.domain;

public enum LadderDirection {

    LEFT(- 1), RIGHT(1), NONE(0);

    private final int value;

    LadderDirection(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
