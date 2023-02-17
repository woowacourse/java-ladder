package domain;

import java.util.Arrays;

public enum LadderSymbol {

    BLANK(" "),
    FOOTHOLD("-"),
    BAR("|");

    private final String symbol;

    LadderSymbol(final String symbol) {
        this.symbol = symbol;
    }

    public static String draw(final String symbol, final int repeatedNumber) {
        return find(symbol).symbol.repeat(repeatedNumber);
    }

    private static LadderSymbol find(final String symbol) {
        return Arrays.stream(values())
                .filter(value -> value.symbol.equals(symbol))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
