package domain.model;

import java.util.Objects;

public class Player {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private static final String LENGTH_ERROR_MESSAGE = "이름 길이는 " + MIN_LENGTH + "~" + MAX_LENGTH + " 사이여야 합니다.";
    private final String name;

    public Player(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        if (isInvalidLength(name)) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }

    private static boolean isInvalidLength(final String name) {
        return name.length() < MIN_LENGTH || name.length() > MAX_LENGTH;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Player player = (Player) o;
        return Objects.equals(getName(), player.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    public String getName() {
        return name;
    }
}
