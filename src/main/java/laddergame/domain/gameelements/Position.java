package laddergame.domain.gameelements;

public class Position {
    // TODO 범위 안에 있는지 판단하는 메서드
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
