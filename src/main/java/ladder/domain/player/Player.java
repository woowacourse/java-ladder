package ladder.domain.player;

import java.util.Objects;
import ladder.domain.ladder.Ladder;

public record Player(Name name, Location location) {
    private static final Location DEFAULT_LOCATION = new Location(0);

    public Player(Name name) {
        this(name, DEFAULT_LOCATION);
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
