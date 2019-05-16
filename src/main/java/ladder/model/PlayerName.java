package ladder.model;

import ladder.model.frame.Name;

import java.util.Objects;

public class PlayerName extends Name {

    public PlayerName(String name) {
        super(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerName)) return false;
        PlayerName that = (PlayerName) o;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    private String getName() {
        return name;
    }

}
