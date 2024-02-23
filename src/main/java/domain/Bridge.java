package domain;

public enum Bridge {
    EMPTY(" ", false), EXIST("-", true);

    private final String symbol;
    private final boolean existence;

    Bridge(final String symbol, final boolean existence) {
        this.symbol = symbol;
        this.existence = existence;
    }

    public boolean isExist() {
        return this.existence;
    }

    public String getSymbol() {
        return this.symbol;
    }
}
