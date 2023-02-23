package ladder.domain;

import java.util.Objects;

public class Player {
    private final Name name;
    private Position position;

    public Player(String name) {
        this.name = new Name(name);
    }

    public Player(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Position climbDownLadder(Ladder ladder) {
        return ladder.climbDownFrom(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player p = (Player) o;
        return Objects.equals(name, p.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name.getName();
    }

    public Position getPosition() {
        return position;
    }
}
