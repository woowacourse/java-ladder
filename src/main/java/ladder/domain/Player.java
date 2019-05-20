package ladder.domain;

import java.util.Objects;

public class Player {
    static final int MAX_NAME_LENGTH = 5;
    static final int MIN_NAME_LENGTH = 1;

    private final String name;

    public Player(final String name) {
        this.name = name.trim();
        validateNameLength();
    }

    private void validateNameLength() {
        if (name.length() > MAX_NAME_LENGTH || name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 1자 이상 5자 이내여야 합니다.");
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