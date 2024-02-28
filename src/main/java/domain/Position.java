package domain;

public class Position {

    private Integer position;

    public Position(int position) {
        this.position = position;
    }

    public void movePositionLeft() {
        position -= 1;
    }

    public void movePositionRight() {
        position += 1;
    }

    public int getPosition() {
        return this.position;
    }
}
