package model;

public class Participant {

    private final Name name;
    private Position position;

    public Participant(Name name) {
        this.name = name;
        this.position = new Position(0);
    }

    Participant(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void moveRight() {
        this.position = position.increment();
    }

    public void moveLeft() {
        this.position = position.decrement();
    }
    public Position getPosition() {
        return position;
    }
}
