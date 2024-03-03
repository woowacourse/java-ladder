package domain.player;

import java.util.Objects;

public class Player {

    protected static final int MIN_NAME_LENGTH = 1;
    protected static final int MAX_NAME_LENGTH = 5;
    protected static final String NAME_LENGTH_RANGE_MESSAGE = String.format("이름은 %d~%d자 사이여야 합니다.", MIN_NAME_LENGTH, MAX_NAME_LENGTH);

    private final String name;

    public Player(String name) {
        validateNameLength(name);

        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_RANGE_MESSAGE);
        }
    }

    public String getName() {
        return this.name;
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
}
