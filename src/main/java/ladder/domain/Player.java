package ladder.domain;

import java.util.Objects;

public class Player {
    public static final int MAX_NAME_LENGTH = 5;
    private String name;
    private int position;

    public Player(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    public void goDown(final Line line) {
        position += line.getDirection(position).getValue();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean matchName(String name) {
        return this.name == name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return position == player.position &&
                Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
