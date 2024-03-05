package laddergame.view;

import laddergame.domain.Rung;

public enum LineSymbol {
    DASH("-----", Rung.BRIDGE),
    SPACE("     ", Rung.EMPTY);

    private final String symbol;
    private final Rung rung;

    LineSymbol(String symbol, Rung rung) {
        this.symbol = symbol;
        this.rung = rung;
    }

    public static String getSymbolByLine(Rung rung) {
        if (rung.equals(DASH.rung)) {
            return DASH.symbol;
        }
        return SPACE.symbol;
    }
}
