package domain.player;


public class Player {

    private final Name name;
    private final Position position;

    public Player(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public boolean isSamePosition(Position otherPosition) {
        return position.equals(otherPosition);
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

    public void move(int value) {
        position.calculate(value);
    }
}
