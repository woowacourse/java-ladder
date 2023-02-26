package ladder.domain.player;

public class Position {

    private int position;

    public Position(final int position) {
        this.position = position;
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
