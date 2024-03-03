package domain;

public class Position {

    public final int position;
    public Position(final int position) {
        this.position = position;
    }

    public boolean isLast(int lineSize) {
        return position == lineSize;
    }
}
