package ladder.view.constant;

public enum LadderOutputSymbol {

    BAR_SYMBOL("-"),
    EMPTY_BAR_SYMBOL(" "),
    LADDER_VERTICAL_SYMBOL("|");

    private final String symbol;

    LadderOutputSymbol(String symbolValue) {
        this.symbol = symbolValue;
    }

    public String getSymbol() {
        return symbol;
    }

    public static String decideLadderSymbol(boolean input) {
        if(input) {
            return BAR_SYMBOL.symbol;
        }

        return EMPTY_BAR_SYMBOL.symbol;
    }
}
