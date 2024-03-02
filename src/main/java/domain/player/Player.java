package domain.player;

import domain.ladder.DirectionalPoint;
import java.util.Objects;

public class Player {
    private final Name name;
    private int position;

    public Player(final Name name, final int position) {
        this.name = name;
        this.position = position;
    }

    public void move(DirectionalPoint ladderPoint) {
        position += ladderPoint.getDirection();
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        final Player player = (Player) object;
        return this.getName().equals(player.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getName());
    }
}
