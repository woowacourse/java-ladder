package ladder.domain;

import java.util.Objects;

public record Player(Name name, Location location) {
    public Player(Name name) {
        this(name, new Location(0));
    }

    public Player climb(Ladder ladder) {
        return new Player(name, ladder.findResultLocation(location));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
