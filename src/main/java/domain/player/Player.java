package domain.player;

public class Player {

    private final Name name;
    private final Position position;

    public Player(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void moveRight() {
        position.increase();
    }

    public void moveLeft() {
        position.decrease();
    }

    public boolean isSamePosition(int other) {
        return position.same(other);
    }

    public boolean isSameName(String otherName) {
        return name.isSame(otherName);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
