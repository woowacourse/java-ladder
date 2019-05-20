package ladder.domain;

import java.util.Objects;

public class Player {
    private static final int MINIMUM_LENGTH_OF_NAME = 1;
    private static final int MAXIMUM_LENGTH_OF_NAME = 5;

    private final String name;

    public Player(String name) {
        validateLength(name.trim());
        this.name = name.trim();
    }

    private void validateLength(String name) {
        if (name.length() < MINIMUM_LENGTH_OF_NAME || name.length() > MAXIMUM_LENGTH_OF_NAME) {
            throw new IllegalArgumentException("이름은 1~5자만 가능합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
