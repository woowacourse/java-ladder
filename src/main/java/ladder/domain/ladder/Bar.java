package ladder.domain.ladder;

public enum Bar {

    CONNECTED(true),
    UNCONNECTED(false);

    private final boolean value;

    Bar(boolean value) {
        this.value = value;
    }

    public static Bar from(boolean connected) {
        if (connected) {
            return CONNECTED;
        }

        return UNCONNECTED;

    }

    public boolean getValue() {
        return this.value;
    }

}
