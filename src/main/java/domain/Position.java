package domain;

public enum Position {
    LEFT(1,"     ",true),
    RIGHT(-1,"-----",false),
    DOWN(0,"     ",true);

    private final int move;
    private final String format;
    private final boolean moveAble;

    Position(int move, String format,boolean moveAble) {
        this.move = move;
        this.format = format;
        this.moveAble = moveAble;
    }

    public int getMove() {
        return move;
    }

    public String getFormat() {
        return format;
    }

    public boolean isMovAble() {
        return moveAble;
    }
}
