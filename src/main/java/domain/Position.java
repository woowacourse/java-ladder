package domain;

public enum Position {
    LEFT(1, "     "),
    RIGHT(-1, "-----"),
    DOWN(0, "     ");

    private final int move;
    private final String format;

    Position(int move, String format) {
        this.move = move;
        this.format = format;
    }

    public int getMove() {
        return move;
    }

    public String getFormat() {
        return format;
    }
}
