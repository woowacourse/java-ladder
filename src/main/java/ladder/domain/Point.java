package ladder.domain;

import java.util.Random;

public enum Point {

    ON("-"),
    OFF(" ");

    private final String symbol;

    Point(String symbol) {
        this.symbol = symbol;
    }

    public static Point getRandomPoint() {
        Point[] points = values();
        return points[new Random().nextInt(points.length)];
    }

    public String getSymbol() {
        return symbol.repeat(5);
    }
    
}
