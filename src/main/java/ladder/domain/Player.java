package ladder.domain;

import java.util.Objects;

public class Player {

    private final Name name;
    private int position;

    public Player(final String value, final int position) {
        this.name = new Name(value);
        this.position = position;
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void move(Direction direction) {
        position += direction.getMove();
    }
}
