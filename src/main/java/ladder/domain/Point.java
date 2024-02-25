package ladder.domain;

public enum Point {

    ON("-"),
    OFF(" ");

    private final String symbol;

    Point(String symbol) {
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
