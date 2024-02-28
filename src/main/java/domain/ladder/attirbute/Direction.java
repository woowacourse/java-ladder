package domain.ladder.attirbute;

public enum Direction {

    LEFT("|---"),
    RIGHT("---|      "),
    DOWN("|      ");

    private final String symbol;

    Direction(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
