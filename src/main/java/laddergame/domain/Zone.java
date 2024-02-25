package laddergame.domain;

public enum Zone {
    BRIDGE("-----"),
    EMPTY("     ");

    private final String symbol;

    Zone(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Zone getZone(boolean buildStatus) {
        if (buildStatus) {
            return BRIDGE;
        }
        return EMPTY;
    }
}
