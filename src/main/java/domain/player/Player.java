package domain.player;

public class Player {
    private final Name name;
    private int position;

    public Player(final Name name, final int position) {
        this.name = name;
        this.position = position;
    }

    public void move(int direction) {
        position += direction;
    }

    public Name getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
