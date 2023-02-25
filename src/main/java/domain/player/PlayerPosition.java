package domain.player;

public class PlayerPosition {
    private int position;

    private static final String UNABLE_MOVE_MESSAGE = "[ERROR] 사다리 밖으로 이동이 불가능 합니다.";
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
            throw new IllegalArgumentException(UNABLE_MOVE_MESSAGE);
        }
    }
}
