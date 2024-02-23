package laddergame.view;

import laddergame.domain.Point;

public enum PointSymbol {
    POINT("-----"),
    EMPTY("     ");
    private final String symbol;

    PointSymbol(String symbol) {
        this.symbol = symbol;
    }

    public static String getSymbol(final Point point) {
        if (point.isBuilt()) {
            return POINT.symbol;
        }
        return EMPTY.symbol;
    }
}
