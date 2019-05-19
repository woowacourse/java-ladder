package ladder.domain;

import java.util.Objects;

public class Player {
    private final String name;
    private int position;

    Player(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void updatePosition(int moveState) {
        this.position += moveState;
    }

    public int compareTo(Player comparePlayer) {
        return this.position - comparePlayer.position;
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

    public String getName() {
        return name;
    }

    int getPosition() {
        return position;
    }
}
