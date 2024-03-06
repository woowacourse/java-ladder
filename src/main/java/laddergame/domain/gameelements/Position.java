package laddergame.domain.gameelements;

public class Position {
    private int playerPosition;

    public Position(int playerPosition) {
        this.playerPosition = playerPosition;
    }

    public int leftPosition() {
        return playerPosition - 1;
    }

    public int rightPosition() {
        return playerPosition;
    }

    public void moveLeft() {
        playerPosition--;
    }

    public void moveRight() {
        playerPosition++;
    }

    public boolean isSame(Position otherPosition) {
        return playerPosition == otherPosition.getPosition();
    }

    public int getPosition() {
        return playerPosition;
    }
}
