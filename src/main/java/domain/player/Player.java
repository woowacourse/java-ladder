package domain.player;

import domain.ladder.Ladder;
import java.util.Objects;

public class Player {

    private final Name name;
    private int position;

    public Player(Name name) {
        this.name = name;
    }

    public Player(Name name, int position) {
        this.name = name;
        this.position = position;
    }

    public boolean isSameName(String otherName) {
        return name.same(otherName);
    }

    public String play(Ladder ladder) {
        return ladder.play(position);
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Player otherPlayer = (Player) other;
        return Objects.equals(this.name, otherPlayer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
