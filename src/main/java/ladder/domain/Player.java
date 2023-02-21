package ladder.domain;

public class Player {

    private int position;
    private final Name name;

    public Player(final String name) {
        this.name = new Name(name);
        this.position = 0;
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position;
    }

    public void move(boolean left, boolean right) {
        if (left) {
            this.position--;
        }

        if (right) {
            this.position++;
        }
    }
}
