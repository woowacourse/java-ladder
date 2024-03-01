package model;

import java.util.Objects;

public class Participant {

    private final Name name;
    private Position position;

    public Participant(Name name) {
        this.name = name;
        this.position = new Position(0);
    }

    public Participant(Name name, Position position) {
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

    public Name getName() {
        return name;
    }

    public boolean isSameName(Name name) {
        return this.name.equals(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Participant that = (Participant) o;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
