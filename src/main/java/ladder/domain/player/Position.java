package ladder.domain.player;

public class Position {

    private int position;

    private Position(final int position) {
        this.position = position;
    }

    public static Position from(final int position) {
        return new Position(position);
    }

    public void moveLeft() {
        position--;
    }

    public void moveRight() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
