package ladder.domain;

public enum Point {

    ON(true, "-"),
    OFF(false, " ");

    private final boolean status;
    private final String symbol;

    Point(boolean status, String symbol) {
        this.status = status;
        this.symbol = symbol;
    }

    public static Point match(boolean status) {
        if (status) {
            return ON;
        }
        return OFF;
    }

    public String repeatSymbol(int count) {
        return symbol.repeat(count);
    }
}
