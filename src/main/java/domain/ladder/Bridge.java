package domain.ladder;

public enum Bridge {
    EMPTY(" ", false), EXIST("-", true);

    private final String symbol;
    private final boolean existence;

    Bridge(final String symbol, final boolean existence) {
        this.symbol = symbol;
        this.existence = existence;
    }

    public static Bridge getOne(boolean existence) {
        if (existence) {
            return Bridge.EXIST;
        }
        return Bridge.EMPTY;
    }

    public boolean isExist() {
        return this.existence;
    }

    public String getSymbol() {
        return this.symbol;
    }
}
