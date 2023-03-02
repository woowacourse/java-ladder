package ladder.view.constant;

import ladder.domain.ladder.Direction;

public enum LadderOutputSymbol {

    CONNECTED_BAR_SYMBOL("-"),
    UNCONNECTED_BAR_SYMBOL(" "),
    LADDER_VERTICAL_SYMBOL("|");

    private final String symbol;

    LadderOutputSymbol(String symbolValue) {
        this.symbol = symbolValue;
    }

    public static String decideLadderSymbol(Direction input) {
        if (input == Direction.RIGHT) {
            return CONNECTED_BAR_SYMBOL.symbol;
        }

        return UNCONNECTED_BAR_SYMBOL.symbol;
    }

    public String getSymbol() {
        return symbol;
    }

}
