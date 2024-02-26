package laddergame.domain;

public enum Line {
    BRIDGE("-----"),
    EMPTY("     ");

    private final String symbol;

    Line(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
