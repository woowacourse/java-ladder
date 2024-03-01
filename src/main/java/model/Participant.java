package model;

public class Participant {

    private final Name name;
    private Position position;

    public Participant(Name name) {
        this.name = name;
        this.position = new Position(0);
    }

    public void moveRight() {
    }

    public void moveLeft() {
    }
    public Position getPosition() {
        return position;
    }
}
