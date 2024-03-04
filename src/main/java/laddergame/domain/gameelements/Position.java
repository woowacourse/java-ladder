package laddergame.domain.gameelements;

public class Position {
    // TODO 메서드에 의미를 더 담기
    private int playerPosition;

    public Position(int playerPosition) {
        this.playerPosition = playerPosition;
    }

    public int left() {
        return playerPosition - 1;
    }

    public int right() {
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
