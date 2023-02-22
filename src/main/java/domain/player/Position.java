package domain.player;

public class Position {

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public boolean isLeftEnd() {
        return position == 1;
    }

    public boolean isRightEnd(int rightEnd) {
        return position == rightEnd;
    }

    public void moveRight() {
        position++;
    }

    public void moveLeft() {
        position--;
    }

    public int getPosition() {
        return position;
    }
}
