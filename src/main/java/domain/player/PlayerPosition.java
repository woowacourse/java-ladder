package domain.player;

public class PlayerPosition {
    private int position;

    public PlayerPosition(int position) {
        this.position = position;
    }

    public void rightMovement() {
        position++;
    }

    public void leftMovement() {
        position--;
    }

    public int getPosition() {
        return position;
    }
}
