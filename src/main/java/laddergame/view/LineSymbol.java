package laddergame.view;

import laddergame.domain.Line;

public enum LineSymbol {
    DASH("-----", Line.BRIDGE),
    SPACE("     ", Line.EMPTY);

    private final String symbol;
    private final Line line;

    LineSymbol(String symbol, Line line) {
        this.symbol = symbol;
        this.line = line;
    }

    public static String getSymbolByLine(Line line) {
        if (line.equals(DASH.line)) {
            return DASH.symbol;
        }
        return SPACE.symbol;
    }
}
