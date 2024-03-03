package domain;

public class Position {

    public final int position;

    public Position(final int position) {
        this.position = position;
    }

    public boolean canMoveRight(final Line line) {
        if(isLast(line.hasSize())){
            return false;
        }
        return line.hasBridgeAt(position);
    }

    public boolean isLast(int lineSize) {
        return position == lineSize;
    }

    public boolean isFirst() {
        return position == 0;
    }
}
