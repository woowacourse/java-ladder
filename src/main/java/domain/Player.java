package domain;

public class Player {
    private final Name name;
    private final Position position;

    public Player(Name name, int position) {
        this.name = name;
        this.position = new Position(position);
    }

    public void move(Direction direction) {
        position.move(direction);
    }

    public int getPosition() {
        return position.getPosition();
    }
}
