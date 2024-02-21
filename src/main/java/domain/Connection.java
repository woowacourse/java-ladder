package domain;

public enum Connection {
    IS_CONNECTED(true),
    IS_NOT_CONNECTED(false);

    private final boolean value;

    Connection(final boolean value) {
        this.value = value;
    }

    public boolean getValue() {
        return this.value;
    }
}
