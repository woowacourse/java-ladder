package laddergame.view;

import java.util.Arrays;

public enum LineSymbol {
    HORIZONTAL_LINE(true, "-----"),
    BLANK_LINE(false, "     ");

    private final Boolean bool;
    private final String symbol;

    LineSymbol(Boolean bool, String symbol) {
        this.bool = bool;
        this.symbol = symbol;
    }

    public static LineSymbol findByBool(Boolean bool) {
        return Arrays.stream(LineSymbol.values())
            .filter(linesymbol -> linesymbol.bool.equals(bool))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR]"));
    }

    public String getSymbol() {
        return symbol;
    }
}
