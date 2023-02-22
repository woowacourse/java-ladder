package ladder.domain;

public class Player {

    private int position;
    private final Name name;

    public Player(final String name) {
        this.name = new Name(name);
        this.position = 0;
    }

    public Player(final String name, final int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position;
    }

    public void move(Direction direction) {
        if (direction == Direction.LEFT) {
            this.position--;
        }

        if (direction == Direction.RIGHT) {
            this.position++;
        }
    }
}
