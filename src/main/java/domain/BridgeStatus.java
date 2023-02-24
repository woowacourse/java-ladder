package domain;

public enum BridgeStatus {

    EXIST("-----"),
    EMPTY("     ");

    private final String display;

    BridgeStatus(final String display) {
        this.display = display;
    }
}
