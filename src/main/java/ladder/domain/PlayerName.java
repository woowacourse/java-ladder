package ladder.domain;

import java.util.Objects;

public class PlayerName {
    private static final int MAX_PLAYER_NAME_LENGTH = 5;

    private final String name;

    public PlayerName(String name) {
        checkNameLength(name);
        this.name = name;
    }

    private static void checkNameLength(String name) {
        if (name.length() > MAX_PLAYER_NAME_LENGTH) {
            throw new IllegalArgumentException(UserOutput.VIOLATE_PLAYER_NAMES.getOutputMessage());
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerName that = (PlayerName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
