package laddergame.domain.player;


import java.util.Objects;

public class Player {

    private final Name name;
    private final Position position;

    private Player(final String name, final int position) {
        this.name = new Name(name);
        this.position = Position.from(position);
    }

    public static Player of(final String name, final int position) {
        return new Player(name, position);
    }

    public void moveRight() {
        position.moveRight();
    }

    public void moveLeft() {
        position.moveLeft();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Player player = (Player) o;
        return Objects.equals(name, player.name) && Objects.equals(position, player.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    public int getPosition() {
        return position.getPosition();
    }
}
