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
}
