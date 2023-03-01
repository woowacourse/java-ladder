package laddergame.model.ladder;

public class Direction {
    private final boolean direction;

    public Direction(boolean direction) {
        this.direction = direction;
    }

    public boolean isConnect() {
        return direction;
    }
}
