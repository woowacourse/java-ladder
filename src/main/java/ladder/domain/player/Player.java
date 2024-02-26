package ladder.domain.player;

public class Player {
    private final Name name;
    private final Position position;

    public Player(final String name, final int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public String getName() {
        return name.getValue();
    }
}
