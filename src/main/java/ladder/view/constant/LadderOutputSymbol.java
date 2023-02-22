package ladder.view.constant;

import ladder.domain.Bar;

public enum LadderOutputSymbol {

    CONNECTED_BAR_SYMBOL("-"),
    UNCONNECTED_BAR_SYMBOL(" "),
    LADDER_VERTICAL_SYMBOL("|");

    private final String symbol;

    LadderOutputSymbol(String symbolValue) {
        this.symbol = symbolValue;
    }

    public static String decideLadderSymbol(Bar input) {
        if (input.getValue()) {
            return CONNECTED_BAR_SYMBOL.symbol;
        }

        return UNCONNECTED_BAR_SYMBOL.symbol;
    }

    public String getSymbol() {
        return symbol;
    }

}
