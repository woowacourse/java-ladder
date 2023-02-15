package ladder.domain;

public enum Bar {
    MOVABLE_BAR(true),
    UNMOBABLE_BAR(false);

    private final boolean value;

    Bar(boolean value) {
        this.value = value;
    }

    public static Bar getBar(boolean movable) {
        if (movable) {
            return MOVABLE_BAR;
        }

        return UNMOBABLE_BAR;

    }

    public boolean getValue() {
        return this.value;
    }

}
