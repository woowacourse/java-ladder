package view;

public enum LadderElement {
    COLUMN("|"),
    ROW("-".repeat(5)),
    EMPTY(" ".repeat(5));

    private final String symbol;

    LadderElement(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
