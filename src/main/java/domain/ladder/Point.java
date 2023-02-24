package domain.ladder;

public class Point {

    private Direction direction;

    public Point(Direction direction) {
        this.direction = direction;
    }

    public boolean matchDirection(Direction direction) {
        return this.direction == direction;
    }

    public void changeDirection(Direction direction) {
        this.direction = direction;
    }

    public int getLineMovement() {
        return this.direction.getLineMovement();
    }

}
