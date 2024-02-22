package laddergame.view;

public enum BridgeSymbol {
    BRIDGE("-----"),
    EMPTY("     ");
    private final String symbol;

    BridgeSymbol(String symbol) {
        this.symbol = symbol;
    }

    public static String getSymbol(final boolean isBuilt) {
        if (isBuilt) {
            return BRIDGE.symbol;
        }
        return EMPTY.symbol;
    }
}
