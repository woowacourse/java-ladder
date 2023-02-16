package domain;

public enum Bridge {

    EXIST("-----"),
    EMPTY("     ");

    private final String display;

    Bridge(final String display) {
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }
}
