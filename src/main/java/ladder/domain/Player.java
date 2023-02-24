package ladder.domain;

import java.util.Objects;

public class Player {
    private static final int NAME_LENGTH_UPPER_BOUND = 5;
    private static final String INVALID_NAME_LENGTH_MESSAGE =
            "참가자의 이름은 1자 이상, " + NAME_LENGTH_UPPER_BOUND + "자 이하여야 합니다.";
    private static final String RESERVED_NAME = "all";
    private static final String RESERVED_NAME_MESSAGE = "all은 사용할 수 없는 이름입니다.";

    private final String name;

    public Player(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        validateInvalidNameLength(name);
        validateReservedName(name);
    }

    private void validateInvalidNameLength(final String name) {
        if (isInvalidNameLength(name)) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_MESSAGE);
        }
    }

    private boolean isInvalidNameLength(final String name) {
        return name == null || name.isBlank() || NAME_LENGTH_UPPER_BOUND < name.length();
    }

    private void validateReservedName(final String name) {
        if (isReservedName(name)) {
            throw new IllegalArgumentException(RESERVED_NAME_MESSAGE);
        }
    }

    private boolean isReservedName(final String name) {
        return name.equals(RESERVED_NAME);
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
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }
}
