package domain.player;

import exception.MoveException;

public class PlayerPosition {
    private int position;

    private static final int MIN_LADDER_INDEX = 0;

    public PlayerPosition(int position) {
        checkPosition(position);
        this.position = position;
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

    private void checkPosition(int position) {
        if (position < MIN_LADDER_INDEX) {
            throw new MoveException();
        }
    }
}
