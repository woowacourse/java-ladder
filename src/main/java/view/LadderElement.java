package view;

public enum LadderElement {
    COLUMN("|"),
    ROW("-----"),
    EMPTY("     ");

    private final String symbol;

    LadderElement(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
