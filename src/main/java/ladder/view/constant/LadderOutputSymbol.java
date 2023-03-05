package ladder.view.constant;

public enum LadderOutputSymbol {

    CONNECTED_BAR_SYMBOL("-"),
    UNCONNECTED_BAR_SYMBOL(" "),
    LADDER_VERTICAL_SYMBOL("|");

    private final String symbol;

    LadderOutputSymbol(final String symbolValue) {
        symbol = symbolValue;
    }

    public static String decideLadderSymbol(final boolean isRightConnected) {
        if (isRightConnected) {
            return CONNECTED_BAR_SYMBOL.symbol;
        }

        return UNCONNECTED_BAR_SYMBOL.symbol;
    }

    public String getSymbol() {
        return symbol;
    }

}
