package ladder.domain;

import java.util.Arrays;

public enum Point {

    USED("-"),
    UNUSED(" ");

    private final String symbol;

    Point(String symbol) {
        this.symbol = symbol;
    }

    public static Point getByIndex(int index) {
        return Arrays.stream(Point.values())
                .toList()
                .get(index);
    }

    public boolean isUsed() {
        return this == Point.USED;
    }

    public String repeatSymbol(int count) {
        return symbol.repeat(count);
    }
}
