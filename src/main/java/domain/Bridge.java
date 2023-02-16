package domain;

public enum Bridge {

    EXIST("-----"),
    EMPTY("     ");

    private final String display;

    Bridge(final String display) {
        this.display = display;
    }

    public boolean isSerialWith(Bridge next) {
        return this == EXIST && this == next;
    }

    public String getDisplay() {
        return display;
    }
}
