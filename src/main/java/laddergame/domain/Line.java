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

    public static Line getZone(boolean buildStatus) {
        if (buildStatus) {
            return BRIDGE;
        }
        return EMPTY;
    }
}
