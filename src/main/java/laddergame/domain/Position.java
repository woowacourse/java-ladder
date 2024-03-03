package laddergame.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {
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

    public boolean isSame(Position otherPosition){
        return playerPosition==otherPosition.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return playerPosition == position.playerPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerPosition);
    }


    public int getPosition() {
        return playerPosition;
    }

    @Override
    public int compareTo(Position o) {
        return Integer.compare(playerPosition, o.playerPosition);
    }
}
