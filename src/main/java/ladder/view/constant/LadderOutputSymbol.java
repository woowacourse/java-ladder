package ladder.view.constant;

import ladder.domain.ladder.Bar;

public enum LadderOutputSymbol {

    BAR_SYMBOL("-"),
    EMPTY_BAR_SYMBOL(" "),
    LADDER_VERTICAL_SYMBOL("|");

    private final String symbol;

    LadderOutputSymbol(String symbolValue) {
        this.symbol = symbolValue;
    }

    public static String decideLadderSymbol(Bar bar) {
        if (bar.equals(Bar.MOVABLE_BAR)) {
            return BAR_SYMBOL.symbol;
        }
        return EMPTY_BAR_SYMBOL.symbol;
    }

    public String getSymbol() {
        return symbol;
    }

}
